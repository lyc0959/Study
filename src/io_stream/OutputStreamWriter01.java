package io_stream;

import java.io.*;

public class OutputStreamWriter01 {
    public static void main(String[] args) throws IOException {
        String from = "E:/2_ANSI.txt";
        String to = "E:/2_GBK.txt";
        //字节流转换成字符流，并指定编码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(from), "gbk");
        BufferedReader br = new BufferedReader(isr);//用缓冲流处理，效率更高
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(to), "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        String line = "";
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        //关闭外层流
        if (br != null) {
            br.close();
        }
        if (bw != null) {
            bw.close();
        }
    }
}
