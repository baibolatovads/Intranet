package com.company;

import java.io.Serializable;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;

public class Executor extends Person implements Serializable {
    static private ArrayList<Order> orders;

    public Executor() {
    }

    public Executor(String name, String password, String id) {
        super(name, password, id);
    }

    public static void addOrder(Order order){
        orders.add(order);
    }

    void acceptOrder(Order order){
        if(order.type != Type.ACCEPTED)
            order.accept(this);
        else{
            System.out.println("Error: order is already accepted.");
        }
    }

    void rejectOrder(Order order){
        order.reject();
    }

    public String viewNewOrders(){
        String s = "";
        for(Order order : orders){
            if(order.type == Type.PENDING) s += order + "\n";
        }
        return s;
    }

    public String viewAcceptedOrders(){
        String s = "";
        for(Order order : orders){
            if(order.type == Type.ACCEPTED && order.executor == this)
                s += order + "\n";
        }
        return s;
    }

    public String viewDoneOrders(){
        String s = "";
        for(Order order : orders){
            if(order.type == Type.DONE && order.executor == this){
                s += order + "\n";
            }
        }
        return s;
    }
}
