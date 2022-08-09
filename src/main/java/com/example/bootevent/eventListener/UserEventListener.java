package com.example.bootevent.eventListener;

import com.example.bootevent.entity.EventAsyncDto;
import com.example.bootevent.entity.EventManyDto;
import com.example.bootevent.entity.EventUserDto;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    @EventListener
    public void userDataChanged(BaseEvent<EventUserDto> event) {
        System.out.println("user-userDataChanged : " + event);
    }

    @EventListener
    public void asyncUserDataChanged(BaseEvent<EventAsyncDto> event) {
        System.out.println("user-asyncUserDataChanged : " + event);
        throw new RuntimeException("noAsyncDataChanged");
    }

    @EventListener
    public void manyUserDataChanged(BaseEvent<EventManyDto> event) {
        System.out.println("user-manyUserDataChanged : " + event);
    }


}