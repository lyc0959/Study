package collection.set;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {
        Set hastSet = new HashSet();
        hastSet.add("java");
        hastSet.add("php");
        hastSet.add("java");//重复数据不添加
        System.out.println("set="+hastSet);
    }
}
