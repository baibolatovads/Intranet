package com.company;

import java.util.Scanner;

public abstract class Employee extends Person implements Comparable<Employee> {
    protected double salary;

    public Employee(String login, String password, String name, double salary) {
        super(name, password, name);
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
                "salary=" + salary +
                "} " + super.toString();
    }

    @Override
    public Person create(Person s) {
        Employee result = (Employee) super.create(s);
        Scanner sc =  new Scanner(System.in);

        System.out.println("Enter salary: ");
        result.setSalary(sc.nextDouble());
        return result;
    }
}