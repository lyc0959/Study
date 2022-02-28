package collection.set;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExe {
    public static void main(String[] args) {
        HashSet persons = new HashSet();
        Person p1 = new Person(1001,"AA" );
        Person p2 = new Person(1002,"BB" );
        //添加person对象p1和p2，根据p1和p2的哈希值计算索引值(存放位置),person对象哈希值由name和id决定
        persons.add(p1);
        persons.add(p2);
        p1.setName("CC");
        System.out.println(persons);
        persons.remove(p1);//删除不掉p1，因为删除时也会根据哈希值计算索引值，该索引值已经不是原来添加p1时的索引了
        System.out.println(persons);
        persons.add(new Person(1001,"CC"));//能添加，1001,"CC"的哈希值计算的索引位置为空
        System.out.println(persons);
        //能添加,1001,“AA”的索引为最开始p1所在位置，但是对象不相同，添加后形成链表
        persons.add(new Person(1001,"AA"));
        System.out.println(persons);
    }
}

class Person {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
