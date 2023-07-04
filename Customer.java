package com.example.part_02;

import java.util.Scanner;

public class Customer {

    /**
     * creating customer attributes as first name, last name and burger count.
     */
    private final String customerFName;
    private final String customerLName;
    private final String burgerCount;

    /**
     * default constractor
     */
    public Customer(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first name: ");
        this.customerFName = scanner.nextLine();

        System.out.print("Enter last name: ");
        this.customerLName = scanner.nextLine();

        System.out.print("Enter burger count: ");
        this.burgerCount = scanner.nextLine();
    }

    /**
     * getter for getting customer full name.
     * @return
     */
    public String getFullName(){
        return customerFName + " " + customerLName;
    }

    /**
     * getter for getting customer first name.
     * @return
     */
    public String getCustomerFName() {
        return customerFName;
    }

    /**
     * getter for getting customer last name.
     * @return
     */
    public String getCustomerLName() {
        return customerLName;
    }

    /**
     * getter for getting burget count.
     * @return
     */
    public String getBurgerCount() {
        return burgerCount;
    }
}
