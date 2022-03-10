package io_stream.properties;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        //创建一个properties对象
        Properties prop = new Properties();
        //添加配置内容
        prop.setProperty("user","mysql");
        prop.setProperty("password","admin123123");
        prop.setProperty("charset","utf-8");
        prop.setProperty("people","汤姆");
        prop.setProperty("human","玛丽");
        //写入配置文件
        FileOutputStream fos = new FileOutputStream("src/mysql2.properties");
        prop.store(fos,"second properties");
        fos.close();
        System.out.println("配置文件创建/修改完毕!");
    }
}
