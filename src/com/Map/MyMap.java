package com.Map;

import java.util.ArrayList;
import java.util.LinkedList;
/*
    you should override equals and hashcode, for the proper functioning of the code
    otherwise you won't be able to get the value of the key which you have inserted in the map.

    Objects of custom classes can be used as a key in a HashMap.
    But in order to retrieve the value object back from the map without failure,
    there are certain guidelines that need to be followed.
    1)Custom class should follow the contract between hashCode() and equals().
        The contract states that:
            If two objects are equal according to the equals(Object) method, then calling
            the hashCode method on each of the two objects must produce the same integer result.
            Hint: This can be done by implementing hashcode() and equals() in your custom class.
    2) Make custom class immutable.

 */

public class MyMap <K, V> {

    // 1. Creating Structure of Node (data which we will going to store)
    private class Node{
        K key;
        V value;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    // 2. Variable and Array Declaration
    private int numOfNode; // Number of Nodes currently hashmap have;
    private int sizeOfArray; // Size of the bucket array
    private LinkedList<Node> bucket[]; // Creating a bucket array with each index storing a linked List

    // 3. Call MyMap constructor and insitialize all varibale and bcuket array
    public MyMap(){
        this.sizeOfArray = 4;
        this.bucket = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            this.bucket[i] = new LinkedList<>();
        }
    }

    private int hashFuction(K key){
        int bucketIndex = key.hashCode(); // Return any Index
        int bi = Math.abs(bucketIndex); // So that bucketIndex will always be positive
        return bi % sizeOfArray; // Return index between 0 - sizeOfArray
    }

    private int searchInLL(K key, int bucketIndex) {
        LinkedList<Node> ll = bucket[bucketIndex]; // getting LL at index bucketIndex
        for (int i = 0; i < ll.size() ; i++) {
            if(ll.get(i).key == key){
                return i;
            }
        }
        return -1;
    }
    private void rehash() {
        this.sizeOfArray = sizeOfArray * 2;
        this.numOfNode = 0;
        LinkedList<Node> oldBucket[] = bucket;
        bucket = new LinkedList[sizeOfArray];

        for (int i = 0; i < sizeOfArray; i++) {
            bucket[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length ; i++) {
            LinkedList<Node> ll = oldBucket[i];
            for (int j = 0; j < ll.size() ; j++) {
                Node node = ll.get(j);
                put(node.key, node.value);
            }
        }
    }
    // 4. Put Function
    public void put(K key, V value){
        int bucketIndex = hashFuction(key); // this method returns bucket index
        int dataIndex = searchInLL(key, bucketIndex);

        if(dataIndex == -1) {
            // ------ Data doesn't exist -------
            bucket[bucketIndex].add(new Node(key, value));
            numOfNode++;
        }else{
           // ------ Key Exist -----------
            Node data = bucket[bucketIndex].get(dataIndex);
            data.value = value;
        }

        double lambda = (double) numOfNode / sizeOfArray;
//        System.out.println("Lambda Value : " + lambda + "," + "Size of Bucket Array :" + sizeOfArray);
        if(lambda > 0.75){
//            System.out.println("LAMBDA INCREASES!!!!");
            // ------- Rehashing ----------
            rehash();
//            System.out.println("REHASHING DONE!!!!");
        }
    }

    // 4.
    public V get(K key){
        int bucketIndex = hashFuction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if(dataIndex == -1){
            return null;
        }else{
            Node node = bucket[bucketIndex].get(dataIndex);
            return node.value;
        }
    }

    // 5.
    public boolean containsKey(K key){
        int bucketIndex = hashFuction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if(dataIndex == -1){
            return false;
        }

        return true;
    }

    // 6.
    public V remove(K key){
        int bucketIndex = hashFuction(key);
        int dataIndex = searchInLL(key, bucketIndex);

        if(dataIndex == -1) return null;
        else {
            Node node = bucket[bucketIndex].remove(dataIndex);
            numOfNode--;
            return node.value;
        }
    }

    // 7.
    public boolean isEmpty(){
        return numOfNode == 0;
    }

    // 8;
    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < sizeOfArray ; i++) {
            LinkedList<Node> ll = bucket[i];
            for (int j = 0; j < ll.size() ; j++) {
                Node node = ll.get(j);
                keys.add(node.key);
            }
        }
        return keys;
    }
}
