package com.CircularQueue;

class CircularLinkyQueue{
    static class Node{
        int data ;
        Node next;
    }
    Node front = null;
    Node rear = null;

    public void enqueue(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(front == null && rear == null){
            front = rear = node;
        }else{
            rear.next = node;
            rear = node;
            rear.next = front;
        }
    }

    public void dequeue(){
        front = front.next;
        rear.next = front;
    }
    public void display(){
        Node temp;
        temp = front;
        while (temp.next != front){
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
    public void peek(){
        System.out.println(front.data);
    }
}

public class CircularQueueUsingLinkedList {
    public static void main(String[] args) {
        CircularLinkyQueue clq = new CircularLinkyQueue();
        clq.enqueue(12);
        clq.enqueue(32);
        clq.enqueue(54);
        clq.enqueue(65);
        clq.display();
        clq.peek();
        clq.dequeue();
        clq.peek();
        clq.display();
    }
}
