package com.DoublyLinkedList;


class Node {
    int data;
    Node next , prev;
}

class DoublyLinkedList {
    Node head , tail;
    int length=0;

    public void insert(int data){
        Node node = new Node();
        node.next = null;
        node.prev = null;
        node.data = data;
        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.next = null;
        node.prev = null;
        node.data = data;

        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void insertAtEnd(int data){
        Node node = new Node();
        node.data = data;
        node.next = null; node.prev = null;

        node.prev = tail;
        tail.next = node;
        tail = node;
    }

    public void insertAtIndex(int index , int data){
        Node node = new Node();
        node.next = null;
        node.prev = null;
        node.data = data;

        if(index == 0){
            insertAtStart(data);
        }else{
            Node n = head;
            for (int j = 0; j < index -1; j++) {
                n = n.next;
            }
            node.prev = n;
            node.next = n.next;
            n.next = node;
            n = node;
            n.next.prev = node;

        }
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("No any elements present");
        }else{
        head = head.next;
        head.prev = null;
        }
    }

    public void deleteEnd(){
        if(tail == null){
            System.out.println("No any elements present");
        }else{
        tail = tail.prev;
        tail.next = null;
        }
    }

    public void deleteAtGivenIndex(int index){

        if (index == 0){
            deleteFirst();
        }else if(index == length-1){
            deleteEnd();
        }else{
            Node temp = head;
            Node p = null;
            int i = 0;
            while (i < index -1){
                temp = temp.next;
                i++;
            }
            p = temp.next;
            temp.next = p.next;
            p.next.prev = temp;
        }
    }

    public void reverse(){
        
    }


    public int getLength(){
        Node n = head;
        while (n != null){
            n = n.next;
            length++;
        }
        return  length;
    }

    public void show(){
        Node n = head;
        System.out.println("The linkedList are : ");
        while (n.next != null){
            System.out.println("Element : " + n.data);
            n = n.next;
        }
            System.out.println("Element : " + n.data);
    }

}

public class Runner {
    public static void main(String[] args) {
       DoublyLinkedList dl1 = new DoublyLinkedList();
       dl1.insert(10);
       dl1.insert(11);
       dl1.insert(12);
       dl1.insert(13);
       dl1.insertAtStart(9);
       dl1.insertAtEnd(14);
       dl1.insertAtEnd(20);
//       dl1.insertAtIndex(3,25);
       dl1.insertAtIndex(3,24);
//       dl1.deleteFirst();
//       dl1.deleteEnd();
        dl1.deleteAtGivenIndex(3);
       dl1.show();

        System.out.println("Length of List : " + dl1.getLength());
    }
}
