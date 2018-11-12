package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person person = new Person();
        /*Scanner sc = new Scanner(System.in);
        person.setName(sc.nextLine());
        person.setLogin(sc.nextLine());
        person.setPassword(sc.nextLine());
        person.setId(sc.nextLine());
        System.out.println(person.toString());*/
       System.out.println(person.create(person));
    }
}
