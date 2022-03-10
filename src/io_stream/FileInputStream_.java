package io_stream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStream_ {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:/1.txt");
        byte[] bytes = new byte[8];//定义字节数组，一次读取8个
        int readLen;
        while ((readLen = fileInputStream.read(bytes)) != -1) {
            //返回的是实际读取的字节个数；若读取数据只有6个字节，返回的就是6
            System.out.print(new String(bytes, 0, readLen));
        }
        fileInputStream.close();
    }
}
