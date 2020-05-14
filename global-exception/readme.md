## 异常捕获演示示例
使用WebExceptionHandler捕捉全局异常
1. 如果抛出的是CustomException，将会返回AjaxResponse.error()信息，json数据
   - HelloController里面的api示例
2. 定义了ModelViewException类，自定义视图异常。如果抛出的异常是ModelViewException，将会返回error视图
   - TemplateController中的示例
   - 使用了切面编程，将需要抛出ModelViewException的方法加上注解@ModelView。当方法抛出异常时，切面自动捕获修改为ModelViewException异常