package com.Queue;

class QueueArray{
    int queue[] = new int[5];
    int front = -1;
    int rear = -1;

    public void enqueue(int data){
        if(rear == 4){
            System.out.println("Queue is full!!");
        }else if(front == -1 && rear == -1){
            front = rear = 0;
            queue[rear] = data;
        }else{
            rear++;
            queue[rear] = data;
        }
    }
    public void dequeue(){
        if(front == -1 && rear == -1) {
            System.out.println("Queue is Empty !!");
        }else if(front == rear){
            front = rear = -1;
        }else{
            System.out.println(queue[front]);
            front++;
        }
    }
    public void display(){
      if(front == -1 && rear == -1){
          System.out.println("Queue is Empty!!");
      }else{
          System.out.print("Queue : ");
          for (int i = front; i < rear + 1 ; i++) {
              System.out.print(queue[i] + " ");
          }
      }
    }
    public void peek(){
        System.out.println("");
        System.out.println(queue[front]);
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
       QueueArray que = new QueueArray();
       que.enqueue(12);
       que.enqueue(32);
       que.enqueue(43);
       que.enqueue(19);
       que.enqueue(20);
       que.dequeue();
       que.display();
       que.peek();

    }
}
