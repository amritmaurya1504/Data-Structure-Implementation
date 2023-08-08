package com.Map;

public class Runner {
    public static void main(String[] args) {
        MyMap<Integer, Integer> map = new MyMap<>();
        map.put(1,12);
        map.put(2,23);
        map.put(3,23);
        map.put(4,45);
        map.put(5,54);
        map.put(6,8787);
        map.put(1,5445);

        System.out.println(map.get(1));
        System.out.println(map.containsKey(89));
        map.remove(6);
        System.out.println(map.keySet());
        System.out.println(map.isEmpty());
    }
}
