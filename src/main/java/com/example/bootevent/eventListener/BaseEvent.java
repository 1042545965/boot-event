package com.example.bootevent.eventListener;

import com.example.bootevent.enums.OperationTypeEnum;
import lombok.Getter;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

public class BaseEvent<T> implements ResolvableTypeProvider {

    @Getter
    private T source;

    @Getter
    private OperationTypeEnum type; // Created / Updated / Deleted

    public BaseEvent(T data, OperationTypeEnum type) {
        this.source = data;
        this.type = type;
    }

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
            ResolvableType.forInstance(source));
    }
}