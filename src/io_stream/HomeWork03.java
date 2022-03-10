package io_stream;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomeWork03 {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("src/pig.properties"));
        String name = prop.getProperty("name");
        int age = Integer.valueOf(prop.getProperty("age"));
        String color = prop.getProperty("color");
        System.out.println(name + "," + age + "," + color);
        Pig pig = new Pig(name, age, color);
        System.out.println(pig);
    }
}

class Pig {
    private String name;
    private int age;
    private String color;

    public Pig(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}

