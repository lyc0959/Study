package io_stream.properties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        //创建对象
        Properties properties = new Properties();
        //加载配置文件
        properties.load(new FileReader("src/mysql.properties"));
        //获取键值对,显示到控制台
        properties.list(System.out);
        //根据key获取值
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("用户名="+user);
        System.out.println("密码="+password);
    }
}
