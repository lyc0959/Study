package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapPractice {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Employee jack = new Employee(1, "jack", 1000);
        Employee tom = new Employee(2, "tom", 2000);
        Employee marry = new Employee(3, "marry", 3000);
        hashMap.put(jack.getId(),jack);
        hashMap.put(tom.getId(),tom);
        hashMap.put(marry.getId(),marry);
        //entrySet遍历
        Set set = hashMap.entrySet();
        for(Object o : set){
            Map.Entry entry = (Map.Entry)o;
            Employee emp = (Employee) entry.getValue();
            if(emp.getSalary()>1000){
                System.out.println(entry.getKey()+","+entry.getValue());
            }
        }
        //keySet遍历
        Set set1 = hashMap.keySet();
        for(Object o : set1){
            int i = (Integer)o;
            System.out.println(i+","+hashMap.get(i));
        }
        //values遍历
        Collection values = hashMap.values();
        for(Object o : values){
            Employee emp = (Employee) o;
            System.out.println(emp);
        }

    }
}

class Employee {
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
