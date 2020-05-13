此示例展示springboot中的
- 监听器
- 过滤器
- 拦截器

的应用。
可以看到请求链路为：监听器-过滤器-拦截器-Controller-拦截器-过滤器-监听器

2020-05-13 10:43:22.925  INFO 19884 --- [nio-8004-exec-2] c.e.listener.config.CustomListener       :  request监听器：可以在这里记录访问次数哦
2020-05-13 10:43:22.926  INFO 19884 --- [nio-8004-exec-2] c.example.listener.config.CustomFilter   : customFilter 请求处理之前
2020-05-13 10:43:22.926  INFO 19884 --- [nio-8004-exec-2] c.example.listener.config.CustomFilter2  : customFilter2 请求处理之前
2020-05-13 10:43:22.926  INFO 19884 --- [nio-8004-exec-2] c.e.l.config.CustomHandlerInterceptor    : CustomHandlerInterceptor preHandle:请求前调用
2020-05-13 10:43:22.927  INFO 19884 --- [nio-8004-exec-2] c.e.listener.controller.HelloController  : HelloController index方法
2020-05-13 10:43:22.929  INFO 19884 --- [nio-8004-exec-2] c.e.l.config.CustomHandlerInterceptor    : CustomHandlerInterceptor postHandle:请求后调用
2020-05-13 10:43:22.929  INFO 19884 --- [nio-8004-exec-2] c.e.l.config.CustomHandlerInterceptor    : CustomHandlerInterceptor afterCompletion:请求调用完成后回调方法，即在视图渲染完成后回调
2020-05-13 10:43:22.929  INFO 19884 --- [nio-8004-exec-2] c.example.listener.config.CustomFilter2  : customFilter2 请求处理之后
2020-05-13 10:43:22.929  INFO 19884 --- [nio-8004-exec-2] c.example.listener.config.CustomFilter   : customFilter 请求处理之后
2020-05-13 10:43:22.929  INFO 19884 --- [nio-8004-exec-2] c.e.listener.config.CustomListener       :  request监听器：销毁
