package com.CircularQueue;

class CircularQueueArray{
    int queue[] = new int[5];
    int front = -1 , rear = -1;

    public void enqueue(int data){
        if(front == -1 && rear == -1){
            front = rear = 0;
            queue[rear] = data;
        }else if((rear + 1)%5 == front){
            System.out.println("Queue is full");
        }else{
            rear = (rear+1)%5;
            queue[rear] = data;
        }
    }
    public void dequeue(){
        if(front == -1 && rear == -1){
            System.out.println("Empty Queue");
        }else if(front == rear){
            System.out.println(queue[front]);
            front = rear = -1;
        }else{
            System.out.println(queue[front]);
            front = (front+1)%5;
        }
    }
    public void peek(){
        System.out.println(queue[front]);
    }
    public void display(){
        int i = front;
        if(front == -1 && rear == -1){
            System.out.println("Empty Queue");
        }else{
            while (i != rear){
                System.out.println(queue[i]);
                i = (i+1)%5;
            }
            System.out.println(queue[rear]);
        }
    }
}

public class CircularQueueUsingArray {
    public static void main(String[] args) {
        CircularQueueArray cqa = new CircularQueueArray();
        cqa.enqueue(12);
        cqa.enqueue(23);
        cqa.enqueue(54);
        cqa.enqueue(65);
        cqa.enqueue(76);
        cqa.display();
        System.out.println("Dequeue....");
        cqa.dequeue();
        cqa.enqueue(77);
        cqa.display();
//        cqa.enqueue(3);
        cqa.peek();
    }
}
