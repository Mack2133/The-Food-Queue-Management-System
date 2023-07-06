package com.example.part_02;

import  java.util.Scanner;

public class CircularQueue {

    // a static final Integer variable named MAX is created and initialized with 100 that will represent the total maximum capacity of the Deque Data structure
    static final int MAX = 100;

    // An Integer array named arr is created that will be the circular array
    int[] circularArray;

    // front variable for Deque data structure.
    int front;

    // rear variable  for the rear of the Deque data structure.
    int rear;

    // size of the Deque class.
    int size;

    public CircularQueue(int size){

        // The arr array is initialized with the MAX value defined earlier
        circularArray = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }


    // The isFull() function will return whether the Deque is full or not
    // If the capacity of the Deque is full, then it will return True, and if there is capacity remaining, False will be returned
    boolean isFull(){
        return ((front == 0 && rear == size -1 )) || front == rear + 1;
    }

    // The isEmpty() function will return whether the Deque is empty
    boolean isEmpty(){
        return (front == -1);
    }

    // The insertFront() function will insert an element x at the front of Deque.
    // There is one parameter to the insertFront() function representing the data that we want to add to the front of the Deque data structure.
    void insertFront(int key){

        // check whether Deque if full or not
        if (isFull()){
            System.out.println("Overflow");
            return;
        }

        // If queue is initially empty
        if(front == -1){
            front = 0;
            rear = 0;
        }

        // front is at first position of queue
        else if (front == 0){
            front=size-1;
        }

        else // decrement front end by '1'
        front = front -1;

        // insert current element into Deque
        circularArray[front] = key;

    }


}
