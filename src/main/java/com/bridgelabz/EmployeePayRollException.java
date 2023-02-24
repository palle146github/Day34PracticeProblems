package com.bridgelabz;

import com.google.protobuf.Empty;

public class EmployeePayRollException extends Throwable{
    private String message;
    enum ExceptionType {NOT_NULL, EMPTY}
    ExceptionType type;
    public EmployeePayRollException(ExceptionType type,String message){
        this.message = message;
        this.type = type;
    }
    public EmployeePayRollException(String message){
        this.message = message;
    }
}
