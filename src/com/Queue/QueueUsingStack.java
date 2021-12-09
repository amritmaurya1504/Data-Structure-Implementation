package com.Queue;

import java.util.Stack;

class QueueStack{
    Stack<Integer> st1 = new Stack<>();
    Stack<Integer> st2 = new Stack<>();
    int count = 0;
    public void enqueue(int data){
        st1.push(data);
        count++;
    }
    public void dequeue(){
        for (int i = 0; i <count ; i++) {
            st2.push(st1.pop());
        }
        int popData = st2.pop();
        System.out.println("Popped Element : " + popData);
        count--;
        for (int i = 0; i <count ; i++) {
            st1.push(st2.pop());
        }
    }
    public void peek(){
//        System.out.println(st1.peek());
        for (int i = 0; i <count ; i++) {
            st2.push(st1.pop());
        }
        int peekData = st2.peek();
        System.out.println("Peeked Element : " + peekData);
        for (int i = 0; i <count ; i++) {
            st1.push(st2.pop());
        }
    }
    public void display(){
        System.out.println(st1);
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        System.out.println("Queue Using Stack");
        QueueStack qs = new QueueStack();
        qs.enqueue(12);
        qs.enqueue(32);
        qs.enqueue(43);
        qs.enqueue(53);

        qs.display();
        qs.dequeue();
        qs.display();
        qs.enqueue(64);
        qs.display();
        qs.dequeue();
        qs.display();
        qs.peek();
        qs.enqueue(55);
        qs.enqueue(65);
        qs.enqueue(90);
        qs.display();
        qs.dequeue();
        qs.peek();

//        System.out.println("After Dequeue....");
//        qs.dequeue();
//        qs.display();
    }
}
