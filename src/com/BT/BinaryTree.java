package com.BT;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

/*T
his Java program implements a binary tree data structure using the Node class.
It allows the user to create a binary tree by entering the data for each node.
The tree is created using a recursive function createTree() that takes user input
to build the tree. The tree can be displayed in an inorder traversal using the
 inorder() function.

Here's a brief description of the implementation:

Node class: This class represents a single node in the binary tree.
It has three attributes:

data: An integer value representing the data stored in the node.
left: A reference to the left child node.
right: A reference to the right child node.
The constructor of the Node class initializes the data and sets left and right
child references to null.
createTree() method: This method allows the user to create the binary tree
by recursively asking for node data. The user is prompted to enter the data
for the current node. If the data is -1, it means the node is a leaf node,
and thus the method returns null. Otherwise, a new Node is created with the
entered data. The method then recursively calls itself to create the left and
right subtrees for the current node, and the left and right child references are
set accordingly.

inorder() method: This method performs an inorder traversal of the binary tree,
which means it visits the left subtree, then the current node, and finally the
right subtree. It prints the data of each node during the traversal.

main() method: In the main function, the program starts by calling the
createTree() method to build the binary tree. Once the tree is created,
it calls the inorder() method to display the data of the nodes in the tree
 in an inorder traversal.

In an interview, you can explain the program as a simple implementation
of a binary tree using a recursive approach. You can mention that the
createTree() function asks the user to input data for each node and recursively
creates the left and right subtrees, effectively building the binary tree.
Finally, the inorder() function is used to display the contents of the tree
in ascending order by visiting nodes in the left, current, and right order.
*/

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
    }
}
class Pair{
    int num;
    Node node;
    Pair(Node node, int num){
        this.num = num;
        this.node = node;
    }
}
public class BinaryTree {

    public static Node createTree(){
        Scanner sc = new Scanner(System.in);
        Node root = null;
        System.out.println("Enter Data : " );
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
    public static int sizeOfBt(Node root){
        if(root == null) return 0;

        return (sizeOfBt(root.left) + sizeOfBt(root.right) + 1);
    }
    public static void preInPostTraversal(Node root){
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> post = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));

        if(root == null) return;

        while (!st.isEmpty()){
            Pair it = st.pop();

            if(it.num == 1){
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left, 1));
                }
            }else if(it.num == 2){
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right, 1));
                }
            }else{
                post.add(it.node.data);
            }
        }
        System.out.println("PreOrder");
        System.out.println(pre);
        System.out.println("InOrder");
        System.out.println(in);
        System.out.println("PostOrder");
        System.out.println(post);

    }

    public static void main(String[] args) {
        Node root = createTree();
        preInPostTraversal(root);
    }
}
