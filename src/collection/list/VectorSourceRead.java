package collection.list;

import java.util.Vector;

public class VectorSourceRead {
    public static void main(String[] args) {
        Vector v = new Vector();//无参构造器默认elementData为10，扩容为2倍
        for(int i=0;i<10;i++){
            v.add(i);
        }
        System.out.println(v);
        for(int i=0;i<10;i++){
            v.add(i);
        }
        System.out.println(v);

    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
