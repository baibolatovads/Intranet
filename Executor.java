package com.company;

import java.io.Serializable;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Executor extends Employee implements Serializable {
    static private HashSet<Order> orders;
    private HashSet<Order> rejectedOrders;

    public Executor(){

    }

    public Executor(String name, String password, String id, String login, double salary) {
        super(name, password, id, login, salary);
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
            if(order.getType() != Type.ACCEPTED
                    && !rejectedOrders.contains(order)) s += order + "\n";
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

    public String viewExecutedOrders(){
        String s = "";
        for(Order order : orders){
            if(order.getType() == Type.DONE && order.getExecutor() == this){
                s += order + "\n";
            }
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Executor executor = (Executor) o;
        return Objects.equals(rejectedOrders, executor.rejectedOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rejectedOrders);
    }
}
