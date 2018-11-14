package com.company;

public abstract class Employee extends Person implements Comparable<Employee> {
    protected double salary;

    public Employee(String login, String password, String name, double salary) {
        super(login, password, name);
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
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
