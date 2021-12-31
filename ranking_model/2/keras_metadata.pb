
�Kroot"_tf_keras_sequential*�J{"name": "sequential", "trainable": true, "expects_training_arg": true, "dtype": "float32", "batch_input_shape": null, "must_restore_from_config": false, "class_name": "Sequential", "config": {"name": "sequential", "layers": [{"class_name": "DenseFeatures", "config": {"name": "dense_features", "trainable": true, "dtype": "float32", "feature_columns": [{"class_name": "NumericColumn", "config": {"key": "mlikenum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p2"}}, {"class_name": "NumericColumn", "config": {"key": "timestamp", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p5"}}, {"class_name": "NumericColumn", "config": {"key": "uavgrating", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p4"}}, {"class_name": "NumericColumn", "config": {"key": "ulikenum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p3"}}, {"class_name": "NumericColumn", "config": {"key": "uratingnum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p1"}}], "partitioner": null}}, {"class_name": "Dense", "config": {"name": "dense", "trainable": true, "dtype": "float32", "units": 128, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}}, "bias_initializer": {"class_name": "Zeros", "config": {}}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}}, {"class_name": "Dense", "config": {"name": "dense_1", "trainable": true, "dtype": "float32", "units": 32, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}}, "bias_initializer": {"class_name": "Zeros", "config": {}}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}}, {"class_name": "Dense", "config": {"name": "dense_2", "trainable": true, "dtype": "float32", "units": 1, "activation": "sigmoid", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}}, "bias_initializer": {"class_name": "Zeros", "config": {}}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}}], "build_input_shape": {"userid": {"class_name": "__tuple__", "items": [null]}, "movieid": {"class_name": "__tuple__", "items": [null]}, "uratingnum": {"class_name": "__tuple__", "items": [null]}, "mlikenum": {"class_name": "__tuple__", "items": [null]}, "ulikenum": {"class_name": "__tuple__", "items": [null]}, "uavgrating": {"class_name": "__tuple__", "items": [null]}, "timestamp": {"class_name": "__tuple__", "items": [null]}}}, "shared_object_id": 10, "build_input_shape": {"userid": {"class_name": "__tuple__", "items": [null]}, "movieid": {"class_name": "__tuple__", "items": [null]}, "uratingnum": {"class_name": "__tuple__", "items": [null]}, "mlikenum": {"class_name": "__tuple__", "items": [null]}, "ulikenum": {"class_name": "__tuple__", "items": [null]}, "uavgrating": {"class_name": "__tuple__", "items": [null]}, "timestamp": {"class_name": "__tuple__", "items": [null]}}, "is_graph_network": false, "full_save_spec": {"class_name": "__tuple__", "items": [[{"userid": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "userid"]}, "movieid": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "movieid"]}, "uratingnum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "uratingnum"]}, "mlikenum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "mlikenum"]}, "ulikenum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "ulikenum"]}, "uavgrating": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "float32", "uavgrating"]}, "timestamp": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "timestamp"]}}], {}]}, "save_spec": {"userid": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "userid"]}, "movieid": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "movieid"]}, "uratingnum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "uratingnum"]}, "mlikenum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "mlikenum"]}, "ulikenum": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "ulikenum"]}, "uavgrating": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "float32", "uavgrating"]}, "timestamp": {"class_name": "TypeSpec", "type_spec": "tf.TensorSpec", "serialized": [{"class_name": "TensorShape", "items": [null]}, "int32", "timestamp"]}}, "keras_version": "2.7.0", "backend": "tensorflow", "model_config": {"class_name": "Sequential", "config": {"name": "sequential", "layers": [{"class_name": "DenseFeatures", "config": {"name": "dense_features", "trainable": true, "dtype": "float32", "feature_columns": [{"class_name": "NumericColumn", "config": {"key": "mlikenum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p2"}}, {"class_name": "NumericColumn", "config": {"key": "timestamp", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p5"}}, {"class_name": "NumericColumn", "config": {"key": "uavgrating", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p4"}}, {"class_name": "NumericColumn", "config": {"key": "ulikenum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p3"}}, {"class_name": "NumericColumn", "config": {"key": "uratingnum", "shape": {"class_name": "__tuple__", "items": [1]}, "default_value": null, "dtype": "float32", "normalizer_fn": "p1"}}], "partitioner": null}, "shared_object_id": 0}, {"class_name": "Dense", "config": {"name": "dense", "trainable": true, "dtype": "float32", "units": 128, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 1}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 2}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 3}, {"class_name": "Dense", "config": {"name": "dense_1", "trainable": true, "dtype": "float32", "units": 32, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 4}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 5}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 6}, {"class_name": "Dense", "config": {"name": "dense_2", "trainable": true, "dtype": "float32", "units": 1, "activation": "sigmoid", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 7}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 8}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 9}], "build_input_shape": {"userid": {"class_name": "__tuple__", "items": [null]}, "movieid": {"class_name": "__tuple__", "items": [null]}, "uratingnum": {"class_name": "__tuple__", "items": [null]}, "mlikenum": {"class_name": "__tuple__", "items": [null]}, "ulikenum": {"class_name": "__tuple__", "items": [null]}, "uavgrating": {"class_name": "__tuple__", "items": [null]}, "timestamp": {"class_name": "__tuple__", "items": [null]}}}}, "training_config": {"loss": "binary_crossentropy", "metrics": [[{"class_name": "MeanMetricWrapper", "config": {"name": "accuracy", "dtype": "float32", "fn": "binary_accuracy"}, "shared_object_id": 11}, {"class_name": "AUC", "config": {"name": "auc", "dtype": "float32", "num_thresholds": 200, "curve": "ROC", "summation_method": "interpolation", "multi_label": false, "label_weights": null}, "shared_object_id": 12}]], "weighted_metrics": null, "loss_weights": null, "optimizer_config": {"class_name": "Adam", "config": {"name": "Adam", "learning_rate": 0.0010000000474974513, "decay": 0.0, "beta_1": 0.8999999761581421, "beta_2": 0.9990000128746033, "epsilon": 1e-07, "amsgrad": false}}}}2
�
�root.layer_with_weights-0"_tf_keras_layer*�{"name": "dense", "trainable": true, "expects_training_arg": false, "dtype": "float32", "batch_input_shape": null, "stateful": false, "must_restore_from_config": false, "class_name": "Dense", "config": {"name": "dense", "trainable": true, "dtype": "float32", "units": 128, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 1}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 2}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 3, "input_spec": {"class_name": "InputSpec", "config": {"dtype": null, "shape": null, "ndim": null, "max_ndim": null, "min_ndim": 2, "axes": {"-1": 5}}, "shared_object_id": 13}, "build_input_shape": {"class_name": "TensorShape", "items": [null, 5]}}2
�root.layer_with_weights-1"_tf_keras_layer*�{"name": "dense_1", "trainable": true, "expects_training_arg": false, "dtype": "float32", "batch_input_shape": null, "stateful": false, "must_restore_from_config": false, "class_name": "Dense", "config": {"name": "dense_1", "trainable": true, "dtype": "float32", "units": 32, "activation": "relu", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 4}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 5}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 6, "input_spec": {"class_name": "InputSpec", "config": {"dtype": null, "shape": null, "ndim": null, "max_ndim": null, "min_ndim": 2, "axes": {"-1": 128}}, "shared_object_id": 14}, "build_input_shape": {"class_name": "TensorShape", "items": [null, 128]}}2
�root.layer_with_weights-2"_tf_keras_layer*�{"name": "dense_2", "trainable": true, "expects_training_arg": false, "dtype": "float32", "batch_input_shape": null, "stateful": false, "must_restore_from_config": false, "class_name": "Dense", "config": {"name": "dense_2", "trainable": true, "dtype": "float32", "units": 1, "activation": "sigmoid", "use_bias": true, "kernel_initializer": {"class_name": "GlorotUniform", "config": {"seed": null}, "shared_object_id": 7}, "bias_initializer": {"class_name": "Zeros", "config": {}, "shared_object_id": 8}, "kernel_regularizer": null, "bias_regularizer": null, "activity_regularizer": null, "kernel_constraint": null, "bias_constraint": null}, "shared_object_id": 9, "input_spec": {"class_name": "InputSpec", "config": {"dtype": null, "shape": null, "ndim": null, "max_ndim": null, "min_ndim": 2, "axes": {"-1": 32}}, "shared_object_id": 15}, "build_input_shape": {"class_name": "TensorShape", "items": [null, 32]}}2
�Broot.keras_api.metrics.0"_tf_keras_metric*�{"class_name": "Mean", "name": "loss", "dtype": "float32", "config": {"name": "loss", "dtype": "float32"}, "shared_object_id": 16}2
�Croot.keras_api.metrics.1"_tf_keras_metric*�{"class_name": "MeanMetricWrapper", "name": "accuracy", "dtype": "float32", "config": {"name": "accuracy", "dtype": "float32", "fn": "binary_accuracy"}, "shared_object_id": 11}2
�Droot.keras_api.metrics.2"_tf_keras_metric*�{"class_name": "AUC", "name": "auc", "dtype": "float32", "config": {"name": "auc", "dtype": "float32", "num_thresholds": 200, "curve": "ROC", "summation_method": "interpolation", "multi_label": false, "label_weights": null}, "shared_object_id": 12}2