package com.company;

import java.io.Serializable;

public class Order implements Serializable {
    Executor executor;
    String message;
    Type type;
    Teacher sender;

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

    @Override
    public String toString() {
        return "Order{" +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
