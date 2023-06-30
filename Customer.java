package com.example.part_02;

import java.util.Scanner;

public class Customer{

    private String firstName;
    private String lastName;
    private int burgerCount;

    public void Cusomter(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter first name of the customer: ");
        this.firstName = scanner.nextLine();

        System.out.print("Enter last name of the customer: ");
        this.lastName = scanner.nextLine();

        System.out.print("Enter the ordered burger count: ");
        this.burgerCount = scanner.nextInt();

        scanner.close();

    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public int getNumberOfBurgers(){
        return burgerCount;
    }

}