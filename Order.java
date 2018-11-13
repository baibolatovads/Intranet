package com.company;

public class Order {
    Executor executor;
    String message;
    Type type;

    public Order(Executor executor, String message, Type type) {
        this.executor = executor;
        this.message = message;
        this.type = type;
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

}
