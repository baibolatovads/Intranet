package com.company;

import java.io.Serializable;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;

public class Executor extends Person implements Serializable {
    static private HashSet<Order> orders;
    private HashSet<Order> rejectedOrders;

    public Executor(){

    }

    public Executor(String name, String password, String id) {
        super(name, password, id);
    }

    public static void addOrder(Order order){
        orders.add(order);
    }

    public void acceptOrder(Order order){
        if(order.getType() != Type.ACCEPTED)
            order.accept(this);
    }

    public void rejectOrder(Order order){
        order.reject();
        rejectedOrders.add(order);
    }

    public void executeOrder(Order order){
        if(order.getType() == Type.ACCEPTED && order.getExecutor() == this){
            order.execute();
        }
    }

    public String viewNewOrders(){
        String s = "";
        for(Order order : orders){
            if(order.getType() != Type.ACCEPTED) s += order + "\n";
        }
        return s;
    }

    public String viewAcceptedOrders(){
        String s = "";
        for(Order order : orders){
            if(order.getType() == Type.ACCEPTED && order.getExecutor() == this)
                s += order + "\n";
        }
        return s;
    }

    public String viewDoneOrders(){
        String s = "";
        for(Order order : orders){
            if(order.getType() == Type.DONE && order.getExecutor() == this){
                s += order + "\n";
            }
        }
        return s;
    }
}
