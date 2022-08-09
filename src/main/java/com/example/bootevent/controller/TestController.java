package com.example.bootevent.controller;

import com.example.bootevent.entity.EventAsyncDto;
import com.example.bootevent.entity.EventManyDto;
import com.example.bootevent.entity.EventOrderDto;
import com.example.bootevent.entity.EventUserDto;
import com.example.bootevent.enums.OperationTypeEnum;
import com.example.bootevent.eventListener.BaseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class TestController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @GetMapping(value = "eventUser")
    public void event() {
        EventUserDto propertiesDto = new EventUserDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(propertiesDto, OperationTypeEnum.INSERT_TYPE));
    }

    @GetMapping(value = "eventOrder")
    public void eventNet() {
        EventOrderDto serviceNteDto = new EventOrderDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }

    @GetMapping(value = "eventMany")
    public void eventMany() {
        EventManyDto serviceNteDto = new EventManyDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }

    @GetMapping(value = "eventAsync")
    public void eventAsync() {
        EventAsyncDto serviceNteDto = new EventAsyncDto();
        applicationEventPublisher.publishEvent(new BaseEvent<>(serviceNteDto, OperationTypeEnum.INSERT_TYPE));
    }

}
