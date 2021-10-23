package com.CircularLinkedList;

class Node{
    int data;
    Node next;
}

class CircularLinkedList{
    Node head , tail;
    int length = 1;

    public void insert(int data){
        Node node = new Node();
        node.data = data;
        node.next = null;

        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }

    public void show(){
        Node temp = head;
        while (temp.next != head){
            System.out.println("Element : " + temp.data);
            temp = temp.next;
        }
            System.out.println("Element : " + temp.data);
    }

    public void insertAtStart(int data){
        Node node = new Node();
        node.data = data;

        if(head == null){
            head = node;
        }else{
        node.next = head;
        head = node;
        tail.next = head;
        }
    }

    public void insertAtEnd(int data){
        if(head == null){
            System.out.println("No any element Present!");
        }else{
            Node node = new Node();
            node.data = data;

            tail.next = node;
            tail = node;
            tail.next = head;
        }
    }

    public void insertAtIndex(int index , int data){
        Node node = new Node();
        node.data = data;

        if(index == 0){
            insertAtStart(data);
        }else{
            Node temp = head;
            int i = 0;
            while (i < index-1){
                temp = temp.next;
                i++;
            }
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void deleteFirst(){

        if (head == null) {
            System.out.println("List is Empty!");
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    public void deleteEnd(){

        Node temp = head;
        Node temp2 = null;

        while (temp.next != head){
            temp2 = temp;
            temp = temp.next;
        }
        temp2.next = head;

    }

    public void deleteAtIndex(int index){


        if(index == 0){
            deleteFirst();
        }else if(index == length-1){
            deleteEnd();
        }else{
            Node n = head;
            Node p = head.next;
            int i = 0;
            while (i < index -1){
                n = n.next;
                p = p.next;
                i++;
            }
            n.next = p.next;
        }
    }

    public void reverse(){
        Node prevNode = null;
        Node currNode = tail.next;
        Node nextNode = currNode.next;
        System.out.println("Reversed LinkedList");
        while (currNode != tail) {
            prevNode = currNode;
            currNode = nextNode;
            nextNode = currNode.next;
            currNode.next = prevNode;
        }
        nextNode.next = tail;
        tail = nextNode;
    }

    public int getLength(){
        Node n = head;
        while (n.next!= head) {
            n = n.next;
            length++;
        }
        return  length;
    }

}

public class Runner {
    public static void main(String[] args) {
       CircularLinkedList cl1 = new CircularLinkedList();
       cl1.insert(1);
       cl1.insert(2);
       cl1.insert(3);
       cl1.insertAtStart(0);
       cl1.insertAtEnd(4);
       cl1.insertAtIndex(2 , 12);
//       cl1.deleteFirst();
//       cl1.deleteEnd();
//        cl1.deleteAtIndex(2);
       cl1.show();
       cl1.reverse();
       cl1.show();
        System.out.println("Length " + cl1.getLength());

    }
}
