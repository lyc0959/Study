package map;

import java.util.HashMap;

public class MapSourceRead {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("java",10);
        hashMap.put("php",10);
        hashMap.put("java",20);
        System.out.println(hashMap);
    }
}
