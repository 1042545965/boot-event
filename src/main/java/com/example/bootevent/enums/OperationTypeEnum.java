package com.example.bootevent.enums;


public enum OperationTypeEnum {

    INSERT_TYPE("insert", "新增"),
    ;
    private String operationType;

    private String operationMsg;


    OperationTypeEnum(String operationType, String operationMsg) {
        this.operationMsg = operationMsg;
        this.operationType = operationType;
    }
}
