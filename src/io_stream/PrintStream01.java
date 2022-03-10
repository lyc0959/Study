package io_stream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream01 {
    public static void main(String[] args) throws IOException {
        PrintStream ps = System.out;//字节打印流
        ps.println("hello world");//默认输出位置是标准输出（显示器）
        ps.write("哈哈哈哈".getBytes());//因为print方法底层用的是write方法，直接调用write进行打印
        System.setOut(new PrintStream("E:/print.txt"));//设置打印输出位置，输出到E:/print.txt
        System.out.println("打印到哪里去了？");
    }
}
