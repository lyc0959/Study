package io_stream.decpattern;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter01 {
    public static void main(String[] args) throws IOException {
        String path = "E:/ok.txt";
        //现在是覆盖模式；若要追加内容，创建节点流对象时加上true：new FileWriter(path,true)
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
        bufferedWriter.write("111111");
        bufferedWriter.newLine();//插入和系统相关的换行符
        bufferedWriter.write("哈哈哈哈哈");
        bufferedWriter.newLine();
        bufferedWriter.write("22222222");
        bufferedWriter.close();
    }
}
