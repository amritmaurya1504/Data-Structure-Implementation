package com.BinaryTree;

import java.util.Scanner;

class Node{
    Node left , right;
    int data;
    public Node(int data){
        this.data = data;
    }
}

public class BinaryTree {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = createTree();

        System.out.println("inOrder : ");
        inOrder(root);
        System.out.println("preOrder : ");
        preOrder(root);
        System.out.println("postOrder : ");
        postOrder(root);

    }
    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
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
    public static Node createTree(){
        Node root = null;
        System.out.println("Enter Data : ");
        int data = sc.nextInt();
        if(data == -1) return null;

        root = new Node(data);
        System.out.println("Enter left for : " + data);
        root.left = createTree();
        System.out.println("Enter Right for : " + data);
        root.right = createTree();

        return root;
    }

}
