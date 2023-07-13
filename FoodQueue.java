package com.example.part_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.Arrays;


public class FoodQueue {

   /**
    * creating attributes for cashiers, burger stock, customer name list, waiting list, getters and setters.
    */
   private static String[] cashier01 = {"X", "X"};
   private static String[] cashier02 = {"X", "X", "X"};
   private static String[] cashier03 = {"X", "X", "X", "X", "X"};

   private String[][] allCashiers = {cashier01, cashier02, cashier03};

   private int burgerStock = 40;  // burger stock.
   private String[] customerNameList = new String[10];  // sorted customer name list.
   private ArrayList<Customer> waitingList = new ArrayList<>(); // waiting list.

   public static String[] getCashier01() {
      return cashier01;
   }

   public static String[] getCashier02() {
      return cashier02;
   }

   public static String[] getCashier03() {
      return cashier03;
   }

   public String[][] getAllCashiers() {
      return allCashiers;
   }

   public void setBurgerStock(int burgerStock) {
      this.burgerStock = burgerStock;
   }

   public int getBurgerStock() {
      return burgerStock;
   }

   /**
    * getter Method to get the burgers stock.
    */
   public int getBurgetStock(){
      return burgerStock;
   }

   /**
    * Method to view all the Queues/Cashiers.
    */
   public void viewAllQueues() {

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

   /**
    * Method to view all empty Queues/Cashiers.
    */
   public void viewAllEmptyQueues() {

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

   /**
    * Method to save data into a separate file named Program_Data.txt.
    */
   public void saveDate() {
      // converting Arraylist into an array in order to use testing method.
      String[] arrayWaitingList = waitingList.toArray(new String[waitingList.size()]);

      Arrays.fill(customerNameList, "");

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

            fileWriter.write("Customer Names: " + Arrays.toString(customerNameList).replace("[", "").replace("]", "") + "\n");

            fileWriter.write("Waiting List: " + Arrays.toString(arrayWaitingList).replace("[", "").replace("]", "") + "\n");

            fileWriter.write("Remaining burger stock: " + burgerStock + "\n");
            fileWriter.close();

         } else {
            System.out.println("Error while creating the file");
         }

      } catch (IOException ex) {
         System.out.println("An error occurred.");
      }
   }

   /**
    * Method to load data from previously saved file which named Program_Data.txt.
    */
   public void loadData() {
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

   /**
    * creating a method to add customers to the queses.
    * option must select the queue with the minimum length.
    */
   public void addCustomerToQueue() {

      Scanner inputDetails = new Scanner(System.in);

      System.out.print("Customer first name: ");
      String firstName = inputDetails.nextLine();

      System.out.print("Customer last name: ");
      String lastName = inputDetails.nextLine();

      int burgerCount = 0;

      while (true) {
         try {
            System.out.print("Burger count: ");
            burgerCount = inputDetails.nextInt();
            inputDetails.nextLine(); // Consume the newline character
            break;
         } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer for the burger count.");
            inputDetails.nextLine(); // Consume the invalid input
         }
      }

      Customer customer = new Customer(firstName, lastName, burgerCount);

      int minCustomers = 5;
      int minCashierIndex = -1;

      for (int i = 0; i < allCashiers.length; i++) {
         int customers = 0;
         for (int j = 0; j < allCashiers[i].length; j++) {
            if (allCashiers[i][j].equals("O")) {
               customers++;
            }
         }

         if (customers < minCustomers) {
            minCustomers = customers;
            minCashierIndex = i;
         }
      }

      if (minCashierIndex != -1) {
         for (int i = 0; i < allCashiers[minCashierIndex].length; i++) {
            if (allCashiers[minCashierIndex][i].equals("X")) {
               allCashiers[minCashierIndex][i] = "O";
               System.out.println("Customer successfully added to the queue number 0" + (minCashierIndex + 1));
               return; // Exit the method after adding the customer to a queue
            }
         }
      }

      // If no empty space is available, add the customer to the waitingList
      waitingList.add(customer);
      System.out.println("Customer added to the waiting list.");
   }

   /**
    * Method to print remaining burgers count.
    */
   public String remainingBurgersCount(){
      return "Remaining burgers count: " + burgerStock;
   }

   /**
    * Method to perform the addition of burgers into stock.
    */
   public void addBurgersToStock(){

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

   /**
    * Method to sort customer names alphabetically.
    */
   public void sortCustomerNameList() {

      Arrays.fill(customerNameList,"");
      Arrays.sort(customerNameList);

      // Print the sorted customer names
      System.out.println("Sorted Customer Names:");
      for (String name : customerNameList) {
         if (name != "" && !name.isEmpty()) {
            System.out.println(name);
         }
      }
   }

   /**
    * Method to calculate the income of each Queue/Cashier.
    */
   public void cashierIncome (){

      RemoveServedCustomer removeServedCustomer = new RemoveServedCustomer();

      System.out.println("Cashier 01: " + removeServedCustomer.getCashier01Revenue() + "\n" +
              "Cashier 02: " + removeServedCustomer.getCashier02Revenue() + "\n" +
              "Cashier 03: " + removeServedCustomer.getCashier03Revenue());
   }

   /**
    * Method to remove a customer from a Queue/Cashier.
    */
   public void removeCustomerFromQueue() {

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

   public void removeServedCustomer(){
      Scanner scanner = new Scanner(System.in);

      int cashierNumberInput;

      while(true) {
         try {
            cashierNumberInput = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume the newline character
            break;
         } catch (InputMismatchException ex){
            System.out.println("Invalid input. Please enter a valid integer for the burger count.");
            scanner.nextLine(); // Consume the invalid input
         }
      }

      while (true){
         if (cashierNumberInput < 3 && cashierNumberInput >= 0) {

            if(cashierNumberInput == 0){
               allCashiers[cashierNumberInput][0] = "X";
               System.out.println("Customer successfully removed from cashier number " + (cashierNumberInput + 1));
               movingCustomers();
               int lastElement = allCashiers[cashierNumberInput].length - 1;
               allCashiers[cashierNumberInput][lastElement] =
               break;
            }
         } else{
            System.out.println("Enter a valid cashier number (1-3)");
         }
      }
   }

   /**
    * Method to move customers to the front position when it is empty.
    */
   public void movingCustomers() {
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