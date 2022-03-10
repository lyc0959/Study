package io_stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        String path = "E:/1.txt";//定义文件路径
        FileInputStream fileInputStream = new FileInputStream(path);//创建字节输入流
        int readData;
        try {
            while ((readData = fileInputStream.read()) != -1) {//-1表示文件读完了
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }
}
