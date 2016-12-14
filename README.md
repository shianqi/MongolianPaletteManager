<h3>JsonBean</h3>
首先通过post请求向服务器获取信息，<br>
这些信息格式在`JsonBean中`，通过 `gson.jar` 将获取的json格式转换为一个类。
之后遍历这些数据，用 `Graphics2D` 画出路径，并且将图片存在本地。