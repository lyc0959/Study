package collection.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListSource {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList);
        linkedList.remove();
        linkedList.set(1,99);
        System.out.println(linkedList);
        //普通for循环
        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }
        //迭代器
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}
