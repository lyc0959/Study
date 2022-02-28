package collection.set;
/*
模拟数组+链表的结构
 */
public class HashSetStructure {
    public static void main(String[] args) {
        //创建一个Node类型的数组
        Node[] table = new Node[16];
        Node john = new Node("john", null);
        table[2] = john;
        Node jack = new Node("jack", null);
        john.next = jack;
        Node jerry = new Node("jerry", null);
        jack.next = jerry;

    }
}

class Node {
    Object item;
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
