package io_stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream01 {
    public static void main(String[] args) {
        String path = "E:/dog.dat";
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            System.out.println(ois.read());//读取整型
            System.out.println(ois.readUTF());//读取字符串
            Object o = ois.readObject();//读取序列化对象
            System.out.println(o);
            Dog dog = (Dog)o;
            System.out.println(dog.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
