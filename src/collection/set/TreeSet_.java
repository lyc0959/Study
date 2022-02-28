package collection.set;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet compare = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照顺序排序
//                return ((String)o1).compareTo((String)o2);
                //按照字符串长度从小到大进行排序
                return ((String)o1).length()-(((String)o2)).length();
            }
        });
        compare.add("s");
        compare.add("gg");
        compare.add("aaa");
        compare.add("marry");
        System.out.println(compare);
        TreeSet a = new TreeSet();
        a.add(1);
        a.add(2);
        System.out.println(a);
    }
}
