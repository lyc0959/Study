package io_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader01 {
    public static void main(String[] args) {
        String path = "E:/2.txt";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";//按行读取的字符串，按行读取效率高
            while ((line = bufferedReader.readLine()) != null) {//读取至文件末尾返回的是null
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();//只需要关闭处理流，被包装的节点流会自动关闭（in就是我们传入的fileReader）
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
