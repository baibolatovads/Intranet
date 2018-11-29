package com.company;

import java.io.Serializable;
import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Executor extends Employee implements Serializable, Interactive {
    static public ArrayList<Order> orders = new ArrayList<>();
    private ArrayList<Order> rejectedOrders = new ArrayList<>();

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
        else System.out.println("Order is already accepted!");
    }

    public void rejectOrder(Order order){
        order.reject();
        rejectedOrders.add(order);
    }

    public void executeOrder(Order order){
        if(order.getType() == Type.ACCEPTED && order.getExecutor() == this){
            order.execute();
        }
        else System.out.println("Order hasn't been accepted by you!");
    }

    public void viewNewOrders(){
        int i = 1;
        for(Order order : orders){
            if(order.getType() != Type.ACCEPTED
                    && !rejectedOrders.contains(order))
                System.out.println(i + " " + order);
            i++;
        }
    }

    public void viewAcceptedOrders(){
        int i = 1;
        for(Order order : orders){
            if(order.getType() == Type.ACCEPTED && order.getExecutor() == this)
                System.out.println(i + " " + order);
            i++;
        }
    }

    public void viewExecutedOrders(){
        int i = 1;
        for(Order order : orders){
            if(order.getType() == Type.DONE && order.getExecutor() == this){
                System.out.println(i + " " + order);
            }
            i++;
        }
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

    public void session() {

        System.out.println("You are logged as an executor.");
        while (true) {

            System.out.println("Choose option");
            System.out.println("1. View new orders");
            System.out.println("2. View executed orders");
            System.out.println("3. View accepted orders");
            System.out.println("4. Accept order");
            System.out.println("5. Reject order");
            System.out.println("6. Reject every non-accepted order");
            System.out.println("7. Execute order");

            String ans = sc.nextLine();

            if (ans.equals("exit")) break;

            switch (ans) {
                case "1":
                    viewNewOrders();
                    break;
                case "2":
                    viewExecutedOrders();
                    break;
                case "3":
                    viewAcceptedOrders();
                    break;
                case "4":
                case "5":
                case "7":
                    System.out.println("Enter index");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index <= 0 || index > orders.size())
                        System.out.println("Index out of range!");

                    if (ans.equals("4")) acceptOrder(orders.get(index - 1));
                    else if (ans.equals("5")) rejectOrder(orders.get(index - 1));
                    else executeOrder(orders.get(index - 1));
                    break;
                case "6":
                    for (Order o : orders){
                        if(o.getType() != Type.ACCEPTED)
                            rejectOrder(o);
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
