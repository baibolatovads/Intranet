package com.company;

import java.io.Serializable;

public class Order implements Serializable {
    private Executor executor;
    private String message;
    private Type type;
    private Teacher sender;

    public Order(Teacher sender, String message) {
        this.sender = sender;
        this.message = message;
        this.type = type.PENDING;
    }

    public Executor getExecutor() {
        return executor;
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }

    public void accept(Executor executor){
        type = Type.ACCEPTED;
        this.executor = executor;
    }

    public void reject(){
        type = Type.REJECTED;
    }

    public void execute(){
        type = Type.DONE;
    }

    @Override
    public String toString() {
        return "Order{" +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
