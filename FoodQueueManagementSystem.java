package com.example.part_02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FoodQueueManagementSystem {

    static String[] cashier01 = {"O", "X"};
    static String[] cashier02 = {"X", "X", "X"};
    static String[] cashier03 = {"X", "X", "X", "X", "X"};
    static String[][] allCashiers = {cashier01, cashier02, cashier03};
    static int burgerStock = 40;
    static String[] customerNameList = new String[10];

    public static void main(String[] args) {
        Arrays.fill(customerNameList, "");

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
                "110 or IFQ : Income of each queue.",
                "EXT or 999 : Exit the Program."
        };

        for (String option : allOptionsList) {
            System.out.print(option + "\n");
        }

        if (burgerStock < 10) {
            System.out.println("Burger count is going less than 10.Please refill.");
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
                        viewAllQueues();
                    }
                    case "VEQ", "101" -> {
                        viewAllEmptyQueues();
                    }
                    case "ACQ", "102" -> {
                        addCustomerToQueue();
                    }
                    case "RCQ", "103" -> {
                        removeCustomerFromQueue();
                    }
                    case "RSC", "104" -> {
                        removeCustomerFromQueue();
                        burgerStock -= 5;
                    }
                    case "VCS", "105" -> {
                        sortCustomerNameList();
                    }
                    case "SPD", "106" -> {
                        saveDate();
                    }
                    case "LPD", "107" -> {
                        loadData();
                    }
                    case "STK", "108" -> {
                        System.out.println("Remaining burgers count: " + burgerStock);
                    }
                    case "AFS", "109" -> {

                        Scanner addBurger = new Scanner(System.in);
                        System.out.print("How many burgers do you want to add to the stock: ");
                        int addBurgerCount = addBurger.nextInt();

                        if (addBurgerCount + burgerStock > 50) {
                            System.out.println("Burger count can't be exceded total of 50.");
                        } else {
                            burgerStock += addBurgerCount;
                            System.out.println(addBurgerCount + " burgers added to the existing stock.");
                        }
                    }

                    default -> {
                        System.out.println("Enter a valid input.");
                    }
                }
            }
        }
    }

    private static void viewAllQueues() {

        // Displaying the Cashier Menu.

        System.out.println("*****************");
        System.out.println("*    Cashier    *");
        System.out.println("*****************");

        int maxLength = 5;  // max length of all cashiers.

        for (int i = 0; i < maxLength; i++) {
            if (i < cashier01.length) {
                System.out.print(cashier01[i] + "       ");
            } else {
                System.out.print("        ");
            }
            if (i < cashier02.length) {
                System.out.print(cashier02[i] + "       ");
            } else {
                System.out.print("        ");
            }
            if (i < cashier03.length) {
                System.out.print(cashier03[i] + "       ");
            } else {
                System.out.print("        ");
            }
            System.out.println();
        }
        System.out.println(); // to make a space between codes.
        System.out.println("X – Not Occupied O – Occupied");
    }

    public static void viewAllEmptyQueues() {

        int maxLength = 5;

        System.out.println("*****************");
        System.out.println("*    Cashier    *");
        System.out.println("*****************");

        for (int i = 0; i < maxLength; i++) {

            if (i < cashier01.length) {
                if (cashier01[i].equals("X")) {
                    System.out.print("X       ");
                } else {
                    System.out.print("        ");
                }
            } else {
                System.out.print("        ");
            }

            if (i < cashier02.length) {
                if (cashier02[i].equals("X")) {
                    System.out.print("X       ");
                } else {
                    System.out.print("        ");
                }
            } else {
                System.out.print("        ");
            }

            if (i < cashier03.length) {
                if (cashier03[i].equals("X")) {
                    System.out.print("X       ");
                } else {
                    System.out.print("        ");
                }
            } else {
                System.out.print("        ");
            }

            System.out.println();
        }
        System.out.println(); // to make a space between codes.
        System.out.println("X – Not Occupied");
    }

    private static void addCustomerToQueue() {

        Customer customer = new Customer();
        System.out.println(customer.getFullName() + " " + customer.getNumberOfBurgers());

        Scanner scanner = new Scanner(System.in); // getting user input for customer name.
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        while (true) {

            int cashierNumber = 0;
            try {
                System.out.print("Enter which cashier number that you want to add the new customer(1-3): ");
                cashierNumber = scanner.nextInt() - 1;

            } catch (InputMismatchException ex) {
                System.out.println("Enter an integer value.");
            }

            if (cashierNumber >= 0 && cashierNumber < 3) { // validating the inputs.

                boolean customerAdded = false;
                for (int i = 0; i < allCashiers[cashierNumber].length; i++) {
                    if (allCashiers[cashierNumber][i].equals("X")) {

                        allCashiers[cashierNumber][i] = "O";
                        int spot = cashierNumber + i;
                        customerNameList[spot] = customerName;
                        customerAdded = true;
                        System.out.println("Customer successfully added to the cashier 0" + (cashierNumber + 1) + ".");
                        break;
                    }
                }
                if (!customerAdded) {
                    System.out.println("There is no empty spots in cashier " + (cashierNumber + 1));
                    break;
                }
            }
            break;
        }
    }

    private static void removeCustomerFromQueue() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the cashier number: ");
            int cashierNumber = scanner.nextInt() - 1;

            System.out.print("Enter the cashier spot: ");
            int cashierSpot = scanner.nextInt() - 1;

            if (cashierNumber >= 0 && cashierNumber < 3 && cashierSpot >= 0 && cashierSpot < allCashiers[cashierNumber].length) {
                if (allCashiers[cashierNumber][cashierSpot].equals("O")) {
                    allCashiers[cashierNumber][cashierSpot] = "X";
                    System.out.println("Customer was successfully removed.");
                    movingCustomers();
                } else {
                    System.out.println("There is no customer to remove.");
                }
            } else {
                System.out.println("Please enter a valid input.");
            }

        } catch (InputMismatchException ex) {
            System.out.println("Please enter an integer value.");
        }
    }

    private static void saveDate() {

        File fileDelete = new File("Program_Data.txt");
        fileDelete.delete();

        try {
            File file = new File("Program_Data.txt");
            boolean fileCreated = file.createNewFile();

            if (fileCreated) {
                System.out.println("File named " + file.getName() + " was successfully created in " + file.getAbsolutePath());
                FileWriter fileWriter = new FileWriter("Program_Data.txt");

                fileWriter.write("Cashier 01: " + Arrays.toString(cashier01).replace("[", "").replace("]", "") + "\n");
                fileWriter.write("Cashier 02: " + Arrays.toString(cashier02).replace("[", "").replace("]", "") + "\n");
                fileWriter.write("Cashier 03: " + Arrays.toString(cashier03).replace("[", "").replace("]", "") + "\n");
                fileWriter.write("Customer Names: " + Arrays.toString(customerNameList) + "\n\n");
                fileWriter.write("Remaining burger stock: " + burgerStock + "\n");
                fileWriter.close();

            } else {
                System.out.println("Error while creating the file");
            }

        } catch (IOException ex) {
            System.out.println("An error occurred.");
        }
    }

    private static void loadData() {
        try {
            File file = new File("Program_Data.txt");
            Scanner fileLoad = new Scanner(file);

            if (file.exists()) {

                while (fileLoad.hasNextLine()) {
                    String fileRead = fileLoad.nextLine();
                    System.out.println(fileRead);
                }

            } else {
                System.out.println("File doesn't exist.");
            }

            fileLoad.close();

        } catch (IOException ex) {
            System.out.println("An error occurred.");
        }
    }

    private static void sortCustomerNameList() {
        for (int i = 0; i < customerNameList.length - 1; i++) {
            for (int j = 0; j < customerNameList.length - i - 1; j++) {
                if (customerNameList[j].compareTo(customerNameList[j + 1]) > 0) {
                    String temp = customerNameList[j];
                    customerNameList[j] = customerNameList[j + 1];
                    customerNameList[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(customerNameList));
    }

    private static void movingCustomers() {
        for (int i = 0; i < cashier01.length - 1; i++) {
            if (cashier01[i].equals("X") && cashier01[i + 1].equals("O")) {
                cashier01[i] = "O";
                cashier01[i + 1] = "X";
            }
        }
        for (int i = 0; i < cashier02.length - 1; i++) {
            if (cashier02[i].equals("X") && cashier02[i + 1].equals("O")) {
                cashier02[i] = "O";
                cashier02[i + 1] = "X";
            }
        }
        for (int i = 0; i < cashier03.length - 1; i++) {
            if (cashier03[i].equals("X") && cashier03[i + 1].equals("O")) {
                cashier03[i] = "O";
                cashier03[i + 1] = "X";
            }
        }
    }
}

