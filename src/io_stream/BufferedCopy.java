package io_stream;

import java.io.*;

public class BufferedCopy {
    public static void main(String[] args) throws IOException {
        String from = "E:/2.txt";
        String to = "E:/2copy.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(from));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();//记得要换行，一行一行的数据没有换行符需要我们插入
        }
        //关闭流
        if (bufferedWriter != null) {
            bufferedWriter.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }
}
