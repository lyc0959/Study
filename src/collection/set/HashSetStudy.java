package collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetStudy {
    public static void main(String[] args) {
        Set set = new HashSet();
        System.out.println(set.add("jack"));
        System.out.println(set.add("tom"));
        System.out.println(set.add("marry"));
        System.out.println(set.add("jack"));//set集合不能添加重复的值，所以返回false

        //不能添加重复数据，但new的对象都是不一样的，能够添加
        set = new HashSet();
        set.add("luck");//添加成功
        set.add("luck");//不能添加
        System.out.println(set);
        set.add(new Dog("workman"));//添加成功
        set.add(new Dog("workman"));//添加成功
        System.out.println(set);

        //new的String对象不能重复添加
        set = new HashSet();
        set.add(new String("haha"));//true
        set.add(new String("haha"));//false不能加入？为什么？要看底层源码
        System.out.println("set="+set);




    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }
}
