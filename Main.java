package com.example.part_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FoodQueue foodQueue = new FoodQueue();

        // warning message if the stock of the burgers went lower than 10 pieces.
        if (foodQueue.getBurgetStock() < 10) {
            System.out.println("Burger count is going less than 10.Please refill.");
        }

        String[] allOptionsList = {

                "VAQ or 100 : View all Queues.",
                "VEQ or 101 : View all Empty Queues.",
                "ACQ or 102 : Add customer to a Queue.",
                "RCQ or 103 : Remove a customer from a Queue. (From a specific location)",
                "RSC or 104 : Remove a served customer.",
                "VCS or 105 : View Customers Sorted in alphabetical order (Do not use library sort routine).",
                "SPD or 106 : Store Program Data into file.",
                "LPD or 107 : Load Program Data from file.",
                "STK or 108 : View Remaining burgers Stock.",
                "AFS or 109 : Add burgers to Stock.",
                "IFQ or 110 : Income of each queue.",
                "EXT or 999 : Exit the Program."

        };

        for (String option : allOptionsList) {
            System.out.print(option + "\n");
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter any value from the above list: ");
            String userOption = scanner.nextLine();

            if (userOption.equals("EXT") || userOption.equals("999")) {
                break;
            } else {
                switch (userOption) {

                    case "VAQ", "100" -> {
                        foodQueue.viewAllQueues();
                    }

                    case "VEQ", "101" -> {
                        foodQueue.viewAllEmptyQueues();
                    }

                    case "ACQ", "102" -> {
                        foodQueue.addCustomerToQueue();
                    }

                    case "RCQ", "103" -> {
                        foodQueue.removeCustomerFromQueue();
                    }

                    case "RSC", "104" -> {}

                    case "VCS", "105" -> {}

                    case "SPD", "106" -> {
                        foodQueue.saveDate();
                    }

                    case "LPD", "107" -> {
                        foodQueue.loadData();
                    }

                    case "STK", "108" -> {
                        foodQueue.remainingBurgersCount();
                    }

                    case "AFS", "109" -> {
                        foodQueue.addBurgersToStock();
                    }

                    case "IFQ or 110" -> {}

                    default -> {
                        System.out.println("Enter a valid input.");
                    }
                }
            }
        }
    }
}
