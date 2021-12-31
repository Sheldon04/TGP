import csv
import os
from dataclasses import dataclass
from typing import Tuple, List, Callable, Dict


@dataclass
class TopkData:
    test_user_item_set: dict  # 在测试集上每个用户可以参与推荐的物品集合
    test_user_positive_item_set: dict  # 在测试集上每个用户有行为的物品集合


@dataclass
class TopkStatistic:
    hit: int = 0  # 命中数
    ru: int = 0  # 推荐数
    tu: int = 0  # 行为数

# 根据value获取key
def get_keys(d, value):
    for k, v in d.items():
        if v == value:
            return k

def topk_evaluate(topk_data: TopkData, score_fn: Callable[[Dict[str, List[int]]], List[float]],
                  ks=[1, 2, 5, 10, 20, 50, 100], userMap=None, itemMap=None) -> Tuple[List[float], List[float]]:
    kv = {k: TopkStatistic() for k in ks}

    user_item_set = {user_id: set() for user_id in range(0, len(userMap))}

    for user_id, item_id, label in topk_data:
        # if user_id in user_set and (not only_positive or label == 1):
        user_item_set[user_id].add(item_id)

    csv_path = os.path.join("D:\\PyCharm\\Recommender-System-c5593a592c2e62b42c1178254e96527f66fbf2af(1)", 'result1_test.csv')
    if not os.path.exists(csv_path):
        with open(csv_path, 'w', newline='', encoding="utf-8") as file:
            csvwriter = csv.writer(file)
            for user_id, item_set in user_item_set.items():
                item_set = set(range(len(itemMap))) - item_set
                ui = {'user_id': [user_id] * len(item_set), 'item_id': list(item_set)}
                item_score_list = list(zip(item_set, score_fn(ui)))
                sorted_item_list = [x[0] for x in sorted(item_score_list, key=lambda x: x[1], reverse=True)]

                real_userID = get_keys(userMap, user_id)
                write_set = set(sorted_item_list[:10])
                real_movieID = []
                for i in write_set:
                    real_movieID.append(get_keys(itemMap, i))
                for i in real_movieID:
                    # 写入真实数据
                    result = [real_userID, i]
                    csvwriter.writerow(result)
                # 存在的时候就往里面添加
        file.close()
    else:
        with open(csv_path, 'a', newline='', encoding="utf-8") as file:
            csvwriter = csv.writer(file)
            for user_id, item_set in user_item_set.items():
                item_set = set(range(len(itemMap))) - item_set
                ui = {'user_id': [user_id] * len(item_set), 'item_id': list(item_set)}
                item_score_list = list(zip(item_set, score_fn(ui)))
                sorted_item_list = [x[0] for x in sorted(item_score_list, key=lambda x: x[1], reverse=True)]

                real_userID = get_keys(userMap, user_id)
                write_set = set(sorted_item_list[:10])
                real_movieID = []
                for i in write_set:
                    real_movieID.append(get_keys(itemMap, i))
                for i in real_movieID:
                    # 写入真实数据
                    result = [real_userID, i]
                    csvwriter.writerow(result)
                # 存在的时候就往里面添加
        file.close()
    # positive_set = topk_data.test_user_positive_item_set[user_id]
    for k in ks:
        topk_set = set(sorted_item_list[:k])
        # kv[k].hit += len(topk_set & positive_set)
        kv[k].ru += len(topk_set)
        # kv[k].tu += len(positive_set)
        kv[k].tu += 1
    return [kv[k].hit / kv[k].ru for k in ks], [kv[k].hit / kv[k].tu for k in ks]  # precision, recall
