from typing import List, Callable, Dict
from Recommender_System.utility.evaluation import TopkData, topk_evaluate



def log(epoch, train_loss, train_auc, train_precision, train_recall, test_loss, test_auc, test_precision, test_recall):
    pr = train_precision + train_recall
    train_f1 = 2. * train_precision * train_recall / pr if (pr) else 0
    test_f1 = 2. * test_precision * test_recall / pr if (pr) else 0
    print('epoch=%d, train_loss=%.5f, train_auc=%.5f, train_f1=%.5f, test_loss=%.5f, test_auc=%.5f, test_f1=%.5f' %
          (epoch + 1, train_loss, train_auc, train_f1, test_loss, test_auc, test_f1))


def topk(topk_data: TopkData, score_fn: Callable[[Dict[str, List[int]]], List[float]], ks=[10, 36, 100], userMap=None, itemMap=None):
    precisions, recalls = topk_evaluate(topk_data, score_fn, ks, userMap=userMap, itemMap=itemMap)
    print("数据输出结束!!!")
    for k, precision, recall in zip(ks, precisions, recalls):
        pr = precision + recall
        f1 = 2. * precision * recall / pr if (pr) else 0
        print('[k=%d, precision=%.3f%%, recall=%.3f%%, f1=%.3f%%]' %
              (k, 100. * precision, 100. * recall, 100. * f1), end='')
    print()
