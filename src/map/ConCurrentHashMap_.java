package map;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ConCurrentHashMap_ {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();
        for(int i=0;i<11;i++){//11
            map.put("ts"+i,new Person(i,"p"+i));
        }
        for(int i=11;i<23;i++){//23
            map.put(i,new Person(i,"p"+i));
        }
        map.put(23,new Person(23,"p"+23));
        map.put(24,new Person(24,"p"+24));
        map.put(25,new Person(25,"p"+25));
        System.out.println(map);
    }
}
class Person {
    private int id;
    private String name;

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

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
