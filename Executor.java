package com.company;

import java.io.Serializable;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Executor extends Employee implements Serializable, Interactive {
    static private HashSet<Order> orders;
    private HashSet<Order> rejectedOrders;
    Executor executor;
    Mode mode;
    Person person;
    private static final Scanner sc = new Scanner(System.in);
    public Executor(){

    }

    public Executor(String name, String login, String password){
        super(name, login, password);
    }
    public Executor(String name, String login, String password, String id, double salary) {
        super(name, login, password, id, salary);
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

    public void session(){
            executor = (Executor) person;
            mode = Mode.Executor;

            System.out.println("You are logged as a manager");

            System.out.println("Choose option");
            System.out.println("1. View new orders");
            System.out.println("2. View executed orders");
            System.out.println("3. View accepted orders");

            String ans = sc.nextLine();

            switch (ans){
                case "1":
                    executor.viewNewOrders();
                    break;
                case "2":
                    executor.viewExecutedOrders();
                    break;
                case "3":
                    executor.viewAcceptedOrders();
                    break;
            }
        }

}
