package com.company;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class Person implements Serializable, Interactive {
    protected String name;
    protected String password;
    protected String id;
    protected String login;
    protected static String defaultPassword = "Kbtu111";

    public Person(){
        password = defaultPassword;
    }
    public Person(String name, String password, String id, String login){
        this.name = name;
        this.password = password;
        this.id = id;
        this.login = login;
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

    public String getLogin(){
        return login;
    }

    public String setLogin(String login){
        this.login = login;
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

    @Override
    public int hashCode() {
        return Objects.hash(name, password, id);
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
