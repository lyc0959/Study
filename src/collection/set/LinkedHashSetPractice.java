package collection.set;

import java.util.LinkedHashSet;
import java.util.Objects;

/*
    定义car类，name、price，如果name和price一样，认为是相同元素，不添加
 */
public class LinkedHashSetPractice {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new car("bmw", 100));
        linkedHashSet.add(new car("gl", 200));
        linkedHashSet.add(new car("gl", 200));
        System.out.println(linkedHashSet);
    }
}

class car {
    private String name;
    private int price;

    public car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", price=" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        car car = (car) o;
        return price == car.price && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
