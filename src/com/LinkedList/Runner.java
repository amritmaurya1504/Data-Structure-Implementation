package com.LinkedList;

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;
    Node tail;
    int length= 0;

    //Inserting an element in a linkedList
    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void insetAtStart(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null){
            head = node;
        }else{
        node.next = head;
        head = node;
        }

    }

    public void insertAtIndex(int index , int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(index == 0){
            insetAtStart(data);
        }else{
            Node n = head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            node.next = n.next;
            n.next = node;
        }
    }

    public void deleteFirst(){

        try{
            if(head == null){
                System.out.println("No any Element Present in LinkedList");
            }
            head = head.next;
        }catch (Exception e){
            System.out.println("Some error occured!");
        }
    }

    public void deleteAtEnd(){
        Node n = head;
        Node prev = null;
        if(head == null){
            System.out.println("No any element present!");
        }else{
            while (n.next!= null){
               prev = n;
               n = n.next;
            }

            prev.next = null;

        }
    }

    public void deleteWithGivenValue(int data){
        Node n = head;
        int initialData = n.data;
        if(data == initialData){
            deleteFirst();
        }else if(data == tail.data){
            deleteAtEnd();
        }else{
            Node q = head.next;
            while (q.data != data && q.next != null){
                q = q.next;
                n = n.next;
            }
            if(q.data == data){
                n.next = q.next;
                q = null;
            }else{
                System.out.println("value does not exist!");
            }
        }
    }

    public int getLength(){
        Node n = head;
        while (n != null){
            n = n.next;
            length++;
        }

        return length;
    }

    public void reverse(){
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = head;

        System.out.println("Reversed LinkedList");

        while (nextNode != null){
           nextNode = nextNode.next;
           currNode.next = prevNode;
           prevNode = currNode;
           currNode = nextNode;
        }
        head = prevNode;

    }

    // view element of Linked list;
    public void show(){
        Node n = head;
        while(n.next!= null){
            System.out.println("Element : " + n.data);
            n = n.next;
        }
        System.out.println("Element : " + n.data);
    }
}

public class Runner {
    public static void main(String[] args) {
        System.out.println("Linked List");
        LinkedList l1 = new LinkedList();
        l1.insert(12);
        l1.insert(14);
        l1.insert(13);
        l1.insetAtStart(10);
        l1.insert(14);
        l1.insert(28);
//        l1.insetAtStart(11);
        l1.insertAtIndex(2,22);
        l1.insertAtIndex(3,23);
//        l1.deleteFirst();
//        l1.deleteAtEnd();
//        l1.deleteWithGivenValue(14);
        l1.show();
        System.out.println("Total element in LinkedList are : " + l1.getLength());
        l1.reverse();
        l1.show();
    }
}
