package com.example.bootevent.eventListener;


import com.example.bootevent.entity.EventAsyncDto;
import com.example.bootevent.entity.EventManyDto;
import com.example.bootevent.entity.EventOrderDto;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void orderDataChanged(BaseEvent<EventOrderDto> event) {
        // business logic ...
        System.out.println("order-queryDataChanged : " + event);
    }

    @EventListener
    public void manyOrderDataChanged(BaseEvent<EventManyDto> event) {
        // asyncDataChanged
        System.out.println("order-manyOrderDataChanged : " + event);
    }

    @EventListener
    @Async
    public void asyncOrderDataChanged(BaseEvent<EventAsyncDto> event) {
        System.out.println("order-asyncOrderDataChanged : " + event);
        // 异步抛出异常 不会影响主程序的运行 , 说明不需要在这里保证事务
        throw new RuntimeException("orderAsyncDataChanged");
    }
}