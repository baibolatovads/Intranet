package com.company;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class Person implements Serializable, Interactive {
    protected String name;
    protected String password;
    protected String id;
    protected String login;
    public static String defaultPassword = "Kbtu111";

    public Person(){
        password = defaultPassword;
    }
<<<<<<< HEAD
    public Person(String name, String login){
        this.name = name;
        this.login = login;
=======
    public Person(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
>>>>>>> f85a0b24d05eb0d51b9f231a7110c0959efaf684
    }
    public Person(String name, String login, String password, String id){
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

    public void setLogin(String login){
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
}