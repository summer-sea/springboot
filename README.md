##### 4.9 @ControllerAdvice的三种用法

######  1.预设全局异常



###### 2.预设全局数据

通过 @ControllerAdvice预设全局数据

 * 定义全局数据在任何controller中都可以访问到
 * @ControllerAdvice 配合 @ModelAttribute 预设全局数据
 * 实际上这个注解的作用就是，允许你往 Model 中注入全局属性
 * （可以供所有Controller中注有@Request Mapping的方法使用）
 * 同时在Controller中用将预设的全局数据在Model中取出
 
 ###### 3.请求参数预处理

* 对前段接口传过来的参数做预处理

* 加入接口中连个对象具有同一个属性这是前端接口在传递的时候由于无法区分相同的属性属于谁

* 就会将相同属性的数据进行合并

做参数预处理

* 1.将参数起别名

* 2.正在ControllerAdvice中做InitBinder处理就是加上别名前缀
* 3.在前段页面进行传递参数的时候要加上别名a.name
* 参数预处理 将参数做别名预处理
* 在前端接口冲传递参数时要加上别名a.name
