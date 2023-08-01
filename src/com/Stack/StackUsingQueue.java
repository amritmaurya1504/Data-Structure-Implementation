package com.Stack;
import java.util.*;


/*
*   1. Add all elements to q2;
*   2. Transfer all elements by elements from q1 -> q2
*   3. Swap q1 -> <- q2
* */

/*
*   Using 1 Queue
*   1. Add element to queue and right after that call for loop from i = 1 to len - 1 and
*   remove from queue and add again to the queue
* */

class StackUsingTwoQueue{
    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsingTwoQueue(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int data){
        q2.add(data);
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }
    }

    public void pop(){
        q1.remove();
        return;
    }

    public int peek(){
        return q1.peek();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        StackUsingTwoQueue s1 = new StackUsingTwoQueue();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.pop();
        s1.push(32);
        s1.push(31);
        s1.push(3190);

        System.out.println(s1.peek());
    }
}
