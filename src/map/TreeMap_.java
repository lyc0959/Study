package map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {
    public static void main(String[] args) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("jack",1);
        treeMap.put("marry",2);
        treeMap.put("tom",3);
        treeMap.put("smith",4);
        System.out.println(treeMap);
        TreeMap comp = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //根据字符串大小排序
//                return ((String)o1).compareTo((String)o2);
                //按照字符串长度大小排序
                return ((String)o1).length()-((String)o2).length();
            }
        });
        comp.put("alibaba",1);
        comp.put("berry",1);
        comp.put("Dali",2);
        comp.put("catty",3);
        comp.put("zed",4);
        System.out.println(comp);
    }
}
