package collection.list;

import java.util.LinkedList;

/*
/   双向链表模拟
 */
public class LinkedListSourceRead {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //创建3个节点
        Node jack = new Node("Jack");
        Node tom = new Node("Tom");
        Node marry = new Node("Marry");
        //链接起来构成双向链表
        jack.next = tom;
        tom.next = marry;
        marry.prev = tom;
        tom.prev = jack;
        //指定first和last
        Node first = jack;
        Node last = marry;
        //遍历双向链表
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
        //添加一个元素smith到tom和marry中间
        Node smith = new Node("Smith");
        //修改4个指向
        tom.next = smith;
        marry.prev = smith;
        smith.next = marry;
        smith.prev = tom;
        //再次遍历
        first = jack;
        while (true) {
            if (first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;
        }
    }
}

class Node {
    Node prev;
    Node next;
    Object item;

    Node() {

    }

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "item=" + item;
    }
}
