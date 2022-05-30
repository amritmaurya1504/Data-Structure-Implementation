package com.BT;

import java.util.Scanner;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
    }
}

public class BinaryTree {
    public  static Node createTree(){
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println("Enter Data : ");
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new Node(data);
        System.out.println("Enter data left of " + data);
        root.left = createTree();
        System.out.println("Enter data right of " + data);
        root.right = createTree();

        return root;
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        Node root = createTree();
         System.out.println("inOrder : ");
         inOrder(root);
         System.out.println("preOrder : ");
         preOrder(root);
         System.out.println("postOrder : ");
         postOrder(root);
    }
}
