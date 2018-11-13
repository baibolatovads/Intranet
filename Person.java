package com.company;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Person implements Serializable {
    public String name;
    public String password;
    public String id;

    public Person(){}
    public Person(String name, String password, String id){
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                " name = '" + name + '\'' +
                ",  id = " + id + '\'' +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

       return (name.equals(person.name) && password.equals(person.password) && id.equals(person.id));
    }


}
