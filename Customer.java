package com.example.part_02;

import java.util.Scanner;

public class Customer {

    /**
     * creating customer attributes as first name, last name and burger count.
     */
    private final String customerFName;
    private final String customerLName;
    private final int burgerCount;

    /**
     * constractor with...
     */
    public Customer(String customerFName,String customerLName,int burgerCount){
        this.customerFName = customerFName;
        this.customerLName = customerLName;
        this.burgerCount = burgerCount;
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
    public int getBurgerCount() {
        return burgerCount;
    }
}
