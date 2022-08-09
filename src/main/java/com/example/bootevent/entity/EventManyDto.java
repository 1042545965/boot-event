package com.example.bootevent.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EventManyDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer clientId;

}
