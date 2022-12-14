# boot-event

[参考第三方文档](https://code2life.top/2019/10/31/0046-spring-event/)
## 发布 监听user

```
    // curl http://localhost:8080/test/eventUser
    // 发布 user
    @GetMapping(value = "eventUser")
    public void event() {
        EventUserDto propertiesDto = new EventUserDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(propertiesDto, OperationTypeEnum.INSERT_TYPE));
    }
    // 监听 user
    @EventListener
    public void userDataChanged(BaseEvent<EventUserDto> event) {
        System.out.println("user-userDataChanged : " + event);
    }
```
## 发布 监听 order

```
    // curl http://localhost:8080/test/eventOrder
    // 发布 order
    @GetMapping(value = "eventOrder")
    public void eventNet() {
        EventOrderDto serviceNteDto = new EventOrderDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }
    // 监听 order
    @EventListener
    public void orderDataChanged(BaseEvent<EventOrderDto> event) {
        // business logic ...
        System.out.println("order-queryDataChanged : " + event);
    }
```

## 单发布 多监听

```
    // curl http://localhost:8080/test/eventMany
    // 发布 Many
    @GetMapping(value = "eventMany")
    public void eventMany() {
        EventManyDto serviceNteDto = new EventManyDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }
    // 监听 order 消费 Many
    @EventListener
    public void manyOrderDataChanged(BaseEvent<EventManyDto> event) {
        // asyncDataChanged
        System.out.println("order-manyOrderDataChanged : " + event);
    }
    
    // 监听 user 消费 Many
    @EventListener
    public void manyUserDataChanged(BaseEvent<EventManyDto> event) {
        System.out.println("user-manyUserDataChanged : " + event);
    }
    
```

## 单发布 多监听 同步 异步 

```
    // curl http://localhost:8080/test/eventMany
    // 发布 Async
    @GetMapping(value = "eventAsync")
    public void eventAsync() {
        EventAsyncDto serviceNteDto = new EventAsyncDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }
    // 监听 order 异步消费 Async 
    @EventListener
    @Async
    public void asyncOrderDataChanged(BaseEvent<EventAsyncDto> event) {
        // asyncDataChanged
        System.out.println("order-asyncOrderDataChanged : " + event);
        // 异步抛出异常 不会影响主程序的运行 , 说明不需要在这里保证事务
        throw new RuntimeException("orderAsyncDataChanged");
    }
    
    // 监听 user 同步 消费 Async
    @EventListener
    public void asyncUserDataChanged(BaseEvent<EventAsyncDto> event) {
        System.out.println("user-asyncUserDataChanged : " + event);
        // 同步 进行异常抛出 主程序失败 可以保证 消费事务一致性 但是不影响 异步消费的回滚
        throw new RuntimeException("noAsyncDataChanged");
    }
```
## 发散问题

*如果我现在想要我的监听是顺序的* ， 比如订单 我去监听的时候 可能是需要使用他的 
详情的信息 。所以我需要等订单的详情创建完毕后在去消费 ， 或者有关连到事务的提交方面的操作
可以参考这篇文章 ， 感觉有了  @TransactionalEventListener 这个注解能解决我所想到的
问题了
### 监听排序的问题
你可以通过注解@Order去排序所有的Listener，确保他们按自己的设定的预期顺序执行。
[监听的排序和事务的问题](https://juejin.cn/post/7011685509567086606)
