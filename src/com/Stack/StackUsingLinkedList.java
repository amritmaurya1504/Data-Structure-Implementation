package com.Stack;

class Node {
    int data;
    Node next;
}

class StackLinkedList {
    Node top = null;
    private String x;

    public void push(int data) {
        Node node = new Node();
        node.data = data;
//        node.next = null;

        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }
    public void pop(){
        top = top.next;
    }
    public void peek(){
        System.out.println(top.data);
    }
    public void show() {
        Node n = top;
        if (top == null) {
            System.out.println("Empty List");
        } else {
            while (n != null) {
                System.out.println(n.data);
                n = n.next;
            }
        }

    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        System.out.println("Stack Implementation Using Linkedlist");

        StackLinkedList stl = new StackLinkedList();
        stl.push(12);
        stl.push(32);
        stl.push(2);
        stl.push(132);
        stl.push(14);
        stl.show();
//        stl.pop();
//        System.out.println("Element Popped");
//        stl.show();
        stl.peek();

    }
}
