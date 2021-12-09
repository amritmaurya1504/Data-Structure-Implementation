package com.Stack;

class StackArray{
    int stack[] = new int[5];
    int top = -1;

    public void push(int data){
        if(top == 4){
            System.out.println("Overflow");
        }else{
            top++;
            stack[top] = data;
        }
    }
    public void pop(){
        int items;
        if(top == -1){
            System.out.println("UnderFlow");
        }else{
            items = stack[top];
            top--;
//            System.out.println(items);
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
        stA.push(23);
        stA.push(12);
        stA.push(32);
        stA.push(3);
        stA.push(31);
        stA.display();
//        stA.pop();
        stA.display();
        stA.peek();
    }
}
