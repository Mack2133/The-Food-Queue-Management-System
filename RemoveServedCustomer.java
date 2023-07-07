package com.example.part_02;

public class RemoveServedCustomer extends RemoveCustomerFromQueue{

    /**
     * Method to calculate the income of each Queue/Cashier.
     * burger cost will be taken as 650 for each.
     * when ever a served customer removed from the Cashier/Queue it will be counted as a purchase.
     */
    public void removeServedCustomer() {

        RemoveCustomerFromQueue removeCustomerFromQueue = new RemoveCustomerFromQueue();
        removeCustomerFromQueue.removeCustomerFromQueue();

        foodQueue.setBurgerStock(foodQueue.getBurgetStock() - 5);
    }
}
