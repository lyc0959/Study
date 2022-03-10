package io_stream;

import java.io.*;

public class ObjectOutputStream01 {
    public static void main(String[] args) throws Exception {
        String to = "E:/dog.dat";//序列化的文件格式是.dat
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(to));
        //序列化数据到E:/dog.dat
        //基本数据类型都会完成装箱并且实现序列化接口
        oos.write(100);//int自动装箱为Integer （Integer实现了序列化接口）
        oos.writeUTF("哈哈哈");
        //保存一个dog对象
        oos.writeObject(new Dog("王菜",18));
        System.out.println("序列化完毕!");
        //关闭流
        oos.close();
    }
}