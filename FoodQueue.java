package com.example.part_02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FoodQueue {

   /**
    * creating attributes for cashiers, burger stock, customer name list, waiting list.
    */
   private static String[] cashier01 = {"O", "O"};
   private static String[] cashier02 = {"O", "O", "O"};
   private static String[] cashier03 = {"O", "O", "O", "O", "X"};

   private String[][] allCashiers = {cashier01, cashier02, cashier03};

   static int burgerStock = 40;  // burger stock.
   private String[] customerNameList = new String[10];  // sorted customer name list.
   private ArrayList<String> waitingList = new ArrayList<>(); // waiting list.


   /**
    * getter Method to get the burgers stock.
    * @return
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
    * Method to remove a customer from a Queue/Cahier.
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

   /**
    * Method to save data into a separate file named Program_Data.txt.
    */
   public void saveDate() {
      // converting Arraylist into a array in order to use tostring method.
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

   /**
    * creating a mehtod to add customers to the queses.
    * option must select the queue with the minimum length.
    */
   public void addCustomerToQueue() {

      Customer customer = new Customer();

      boolean customerAdded = false;

      while (true) {

         for (int i = 0; i < allCashiers.length; i++) {
            for (int j = 0; j < allCashiers[i].length; j++) {

               if (allCashiers[i][j].equals("X")) {
                  allCashiers[i][j] = "O";
                  int cashierPosition = i + j;
                  customerNameList[cashierPosition] = "Customer: " + customer.getFullName() + " - Ordered burger count: " + customer.getBurgerCount() + "\n";
                  customerAdded = true;
                  break;
               }
            }
            if (customerAdded) {
               break;
            }
         }
         break;
      }
      if (!customerAdded) {
         waitingList.add("Customer: " + customer.getFullName() + ". Ordered burger count: " + customer.getBurgerCount());
         System.out.println("There are no empty spots in cashiers. Please wait in the waiting list and ones there is a spot you will be added to there.");
      }
   }

   /**
    * Method to print remaining burgers count.
    */
   public String remainingBurgersCount(){
      return "Remaining burgers count: " + burgerStock;
   }

   /**
    * Method to perform the additon of burgers into stock.
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
    * creating a Mehthod to add customers to the Queue/Cashier from the waiting list.
    */

}
