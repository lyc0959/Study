package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        for(int i=0;i<5;i++){
            set.add("set"+i);
        }
        System.out.println(set);
        //迭代器遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.print(next+" ");
        }
        //增强for循环
        System.out.printf("\n");
        for(Object o : set){
            System.out.printf(o+" ");
        }
        //普通for循环无法遍历
        //set集合没有索引，没有get(index)方法
    }
}
