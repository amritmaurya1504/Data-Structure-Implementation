package com.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OurMap<K , V> {
    // Our Map has Bucket Array which is a list of linked list in which each index is pointed to the head of linkedlist
    private List<MapNode<K,V>> bucket;
    private int capacity; // length of bucket
    private int size;   // number of element in the map
    private final int INITIAL_CAPACITY = 5; // Initial length of bucket array

    public OurMap(){
        bucket = new ArrayList<>();
        capacity = INITIAL_CAPACITY;
        for (int i = 0; i < capacity ; i++) {
            bucket.add(null);
        }
    }

    public int getBucketIndex(K key){
        int hashCode = key.hashCode(); // getting hashcode
        return hashCode % capacity; // compression function
    }
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

    public V get(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)) { // if we write head.key == key then this will only compare memory address not actual value so we have to use equals to method
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void put(K key, V value){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        while(head != null){
            if(head.key.equals(key)) { // if we write head.key == key then this will only compare memory address not actual value so we have to use equals to method
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        MapNode<K, V> newNode = new MapNode<>(key, value);
        head = bucket.get(bucketIndex);
        newNode.next = head;
        bucket.set(bucketIndex, newNode);

        double loadFactor = (1.0 * size) / capacity;
        System.out.println("Inserting key " + key);
        System.out.println("load-factor " + loadFactor);
        if(loadFactor >= 0.7){
            rehash();
        }
    }

    public void rehash(){
        System.out.println("Rehashing bucket");
        List<MapNode<K, V>> temp = bucket;
        bucket = new ArrayList<>();
        capacity *= 2;
        for (int i = 0; i < capacity ; i++) {
            bucket.add(null);
        }
        size = 0;

        // now we have to rehash all entries
        for (int i = 0; i < temp.size() ; i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null){
                put(head.key, head.value);
                head = head.next;
            }
        }
    }

    public void remove(K key){
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = bucket.get(bucketIndex);
        MapNode<K, V> prev = null;

        while(head != null){
            if(head.key.equals(key)){
                if(prev == null)
                    bucket.set(bucketIndex, head.next);
                else
                    prev.next = head.next;
                head.next = null;
                size--;
                break;
            }
            prev = head;
            head = head.next;
        }
    }
    public int size(){
        return size;
    }

    // MapNode class is just a node of a LinkedList
    private class MapNode<K, V>{
        K key;
        V value;
        MapNode<K, V> next;
        public MapNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
