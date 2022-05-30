package com.Stack;

class StackArray{
    int stack[] = new int[5];
    int top = -1;

    public void push(int data){
        if(top == 4) {
            System.out.println("OverFlow");
        }else{
            top++;
            stack[top] = data;
        }
    }
    public void pop(){
        if(top == -1) {
            System.out.println("Underflow");
        }else{
            int item = stack[top];
            top--;
        }
    }

    public void peek(){
        if (top == -1){
            System.out.println("Empty");
        }else {
            System.out.println(stack[top]);
        }
    }
    public void display(){
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        StackArray stA = new StackArray();
        stA.push(12);
        stA.push(20);
        stA.push(22);
        stA.push(2222);
        stA.display();
        stA.pop();
        System.out.println("New Stack....");
        stA.display();
        stA.peek();
    }
}
