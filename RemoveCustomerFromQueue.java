package com.example.part_02;

import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class RemoveCustomerFromQueue {

//    FoodQueue foodQueue = new FoodQueue();
//    Scanner scanner = new Scanner(System.in);

    /**
     * Method to remove a customer from a Queue/Cashier.
//     */
//    public void removeCustomerFromQueue() {
//        try {
//            System.out.print("Enter the cashier number: ");
//            int cashierNumber = scanner.nextInt() - 1;
//
//            System.out.print("Enter the cashier spot: ");
//            int cashierSpot = scanner.nextInt() - 1;
//
//            if (cashierNumber >= 0 && cashierNumber < 3 && cashierSpot >= 0 && cashierSpot < foodQueue.getAllCashiers()[cashierNumber].length) {
//                if (foodQueue.getAllCashiers()[cashierNumber][cashierSpot].equals("O")) {
//                    foodQueue.getAllCashiers()[cashierNumber][cashierSpot] = "X";
//                    System.out.println("Customer was successfully removed.");
//                    foodQueue.movingCustomers();
//                } else {
//                    System.out.println("There is no customer to remove.");
//                }
//            } else {
//                System.out.println("Please enter a valid input.");
//            }
//        } catch (InputMismatchException ex) {
//            System.out.println("Please enter an integer value.");
//        }
//    }
//}