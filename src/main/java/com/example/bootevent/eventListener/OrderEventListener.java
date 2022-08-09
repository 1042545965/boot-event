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
        // asyncDataChanged
        System.out.println("order-asyncOrderDataChanged : " + event);
        throw new RuntimeException("orderAsyncDataChanged");
    }
}