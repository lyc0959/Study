package collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/*
    定义员工类（name、salary、birthday），定义MyDate类
    员工的名字和生日一样，就认为是重复，不能添加到hashset中
 */
@SuppressWarnings({"all"})
public class HashSetPractice2 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add(new Employee2("jack", 3000, new MyDate(2022, 2, 24)));
        set.add(new Employee2("tom", 4000, new MyDate(2022, 2, 24)));
        set.add(new Employee2("marry", 5000, new MyDate(2022, 2, 24)));
        set.add(new Employee2("jack", 5000, new MyDate(2022, 2, 24)));
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}

class Employee2 {
    private String name;
    private int salary;
    private MyDate birthday;

    public Employee2(String name, int salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return Objects.equals(name, employee2.name) && Objects.equals(birthday, employee2.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", salary=" + salary + ", birthday=" + birthday;
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}
