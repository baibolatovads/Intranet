package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order implements Serializable {
    private Executor executor;
    private String message;
    private Type type;
    private Teacher sender;
    private Date date;

    public Order(Teacher sender, String message) {
        this.sender = sender;
        this.message = message;
        this.type = type.PENDING;
        date = new Date();
    }

    public Teacher getSender() {
        return sender;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return "Order{" +
                ", message='" + message + '\'' +
                ", type=" + type +
                ", data='" + sdf.format(date) + '\'' +
                '}';
    }


}
