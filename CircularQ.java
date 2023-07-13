package com.example.part_02;

import java.util.ArrayList;

public class  CircularQ {
        private ArrayList<Customer> waitingList = new ArrayList<>();

        public ArrayList<Customer> getWaitingList(){
                return waitingList;
        }

        public Customer getFCWaitingList(){
                return waitingList.get(0);
        }

        // Add a customer to the end of the queue.
        public void enqueue(Customer newCustomer){
                waitingList.add(newCustomer);
        }

        // Remove and return the first customer from the queue.
        public Customer dequeue(){
                if(waitingList.isEmpty()){
                        throw new IllegalStateException("Queue is empty");
                }

                Customer customer = waitingList.get(0);
                waitingList.remove(0);
                return customer;
        }
}