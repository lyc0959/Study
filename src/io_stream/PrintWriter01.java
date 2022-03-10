package io_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter01 {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);//标准输出
        pw.println("hello world!");
        pw.close();
        PrintWriter pw2 = new PrintWriter(new FileWriter("E:/writer.txt"));
        pw2.println("北京欢迎你!");
        pw2.close();//关闭流才会将数据写入文件
    }
}
