package com.Queue;

class Node{
    int data;
    Node next;
}

class QueueLinkedList{
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
        }
    }
    public void dequeue(){
        front = front.next;
    }
    public void display(){
        Node temp;
        if(front == null && rear == null){
            System.out.println("Empty");
        }else {
            temp = front;
            while(temp!= null ){
                System.out.println(temp.data);
                temp = temp.next;
            }
//            System.out.println(temp.data);
        }
    }
    public void peek(){
        System.out.println("Peek : " + front.data);
    }
}

public class QueueUsingLinkedList {
    public static void main(String[] args) {
        QueueLinkedList ql = new QueueLinkedList();
        ql.enqueue(12);
        ql.enqueue(23);
        ql.enqueue(32);
        ql.enqueue(43);
        ql.display();
        ql.dequeue();
        System.out.println("Dequeue.....");
        ql.display();
        System.out.println("Enqueue.....");
        ql.enqueue(34);
        ql.enqueue(54);
        ql.display();
        ql.peek();
    }
}
