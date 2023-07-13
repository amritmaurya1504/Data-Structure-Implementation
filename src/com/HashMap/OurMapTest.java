package com.HashMap;

public class OurMapTest {
    public static void main(String[] args) {
        OurMap<Integer, String> map = new OurMap<>();
        map.put(4,"Patna");
        map.put(3, "Jehanabad");
        map.put(6, "Kolkata");
        map.put(1, "Gaya");
        map.put(5, "Mujafarpur");
        map.put(2, "Howrah");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
        System.out.println(map.get(5));
        System.out.println(map.get(6));
        System.out.println("Size " + map.size());
    }
}
