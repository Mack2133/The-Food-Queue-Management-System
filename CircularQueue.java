package com.example.part_02;

public class CircularQueue {
    private int maxSize;
    private int [] circularQueue;
    private int front;
    private int rear;
    private int nItems;

    public CircularQueue(int s) {
        maxSize = s;
        circularQueue = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int j){
        circularQueue [++rear] = j;
        nItems++;

        if(rear == maxSize - 1)
            System.out.println("Queue is full");

        else {
            circularQueue[++rear] = j;
            nItems++;
        }
    }

    public int remove(){
        if(nItems == 0){
            System.out.println("Queue is empty");
            return  -99;
        }

        else{
            nItems--;
            return circularQueue[front++];
        }
    }

    public int peekFront(){
        if(nItems == 0){
            System.out.println("Queue is empty");
            return -99;
        }
        else{
            return circularQueue[front];
        }
    }

    public static void main(String[] args) {
        CircularQueue circularQueue1 = new CircularQueue(5);

    }


}