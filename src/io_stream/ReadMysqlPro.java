package io_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadMysqlPro {
    public static void main(String[] args) throws IOException {
        //字符缓冲流读取配置文件
        BufferedReader br = new BufferedReader(new FileReader("src/mysql.properties"));
        String line = "";
        while((line = br.readLine()) != null) {
            String[] s = line.split("=");//字符串拆分为字符串数组
            System.out.println(s[0]+"的值是："+s[1]);
        }
        if(br != null) {
            br.close();
        }
    }
}
