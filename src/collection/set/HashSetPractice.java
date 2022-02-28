package collection.set;

import java.util.HashSet;
import java.util.Objects;

/*
    定义员工类，添加到hashset集合中，名字和年龄相同的员工认为是重复的，不添加。
 */
@SuppressWarnings({"all"})
public class HashSetPractice {
    public static void main(String[] args) {
        HashSet es = new HashSet();
        Employee a = new Employee("john",18);
        Employee b = new Employee("john",18);
        System.out.println(es.add(a));
        System.out.println(es.add(b));
        System.out.println(es);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee() {
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    //equals相同取决于name和age字段
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    //通过name和age计算哈希值
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
