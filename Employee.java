package com.company;

import java.io.Serializable;
import java.util.Objects;

public class Employee extends Person implements Comparable, Serializable {
    protected double salary;

    public Employee(String login, String password, String name) {
        super(login, password, name);
    }

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

        
    }
}
