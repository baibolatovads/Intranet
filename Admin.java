package com.company;

import java.util.Scanner;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.io.IOException;


public abstract class Admin extends Employee{


    public enum UserType{
        TEACHER, STUDENT, MANAGER;
    }


    Scanner scanner = new Scanner(System.in);
    public Admin()
    { }


    private static boolean isHaveDigits(String text)
    {
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) >= '0' && text.charAt(i) <= '9')
                return true;
        }
        return false;
    }
    private static boolean isHaveSpace(String text)
    {
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == ' ')
                return true;
        }
        return false;

    }
    public static boolean ValidLogin(String login)
    {
        if(!(login.contains("_") || login.contains("#") || login.contains(".")))
            return false;
        if(isHaveSpace(login))
            return false;
        if(isHaveDigits(login))
            return false;
        return true;
    }
    public static boolean ValidName(String name)
    {
        if(isHaveDigits(name))
            return false;
        if(isHaveSpace(name))
            return false;
        return true;
    }
    static public char GetSymbolByType(UserType Type)
    {
        if(Type == UserType.TEACHER)
            return '.';
        else if(Type == UserType.STUDENT)
            return '_';
        else
            return '#';
    }

    public void AddUser()
    {
        String name,surname,login, faculty;
        UserType type = UserType.STUDENT;
        System.out.println("Enter name:\n");
        name = scanner.nextLine();

        while(!Admin.ValidName(name))
        {
            System.out.println("Not valid name, please input new name\n");
            name = scanner.nextLine();
        }

        System.out.println("\nEnter surname:");
        surname = scanner.nextLine();
        while(!Admin.ValidName(surname))
        {
            System.out.println("Not valid surname, please input new surname\n");
            surname = scanner.nextLine();
        }
        System.out.println("Enter type (1. Teacher\t2. Student\t3.Manager\n");
        int typeINT = scanner.nextInt();
        scanner.nextLine();
        switch (typeINT)
        {
            case 1:
                type = UserType.TEACHER;
                break;
            case 2:
                type = UserType.STUDENT;
                break;
            case 3:
                type = UserType.MANAGER;
                break;
            default:
                type = UserType.STUDENT;
                break;
        }
        char symbolType = Admin.GetSymbolByType(type);
        login = "" + name.charAt(0) + symbolType + surname;
        //haven't finished

    }
}
