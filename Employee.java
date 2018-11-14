package com.company;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class Employee extends Person implements Comparable, Serializable, Interactive {
    protected double salary;

    public Employee(String login, String password, String name, String id) {
        super(login, password, name, id);
    }

    public Employee(String login, String password, String name, String id, double salary) {
        super(login, password, name, id);
        this.salary = salary;
    }

    public Employee() {}

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name=" + name +
                ", salary=" + salary +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee)o;

        if(salary > e.salary) return 1;
        if(salary == e.salary) return 0;
        return -1;
    }

    @Override
    public void login() {
        Scanner s = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.println("Enter name: ");
        name = s.next();
        System.out.println("Enter password: ");
        password = s.next();
    }
}
