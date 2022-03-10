package io_stream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader01 {
    public static void main(String[] args) throws IOException {
        String path = "E:/2_ANSI.txt";
        //字节流转换成字符流，并指定编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"gbk");
        BufferedReader br = new BufferedReader(isr);//用缓冲流处理，效率更高
        String line = "";
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //关闭外层流
        if(br != null) {
            br.close();
        }
    }
}
