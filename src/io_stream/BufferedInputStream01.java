package io_stream;

import java.io.*;

public class BufferedInputStream01 {
    public static void main(String[] args) throws IOException {
        String from = "E:/20.jpg";
        String to = "E:/高楼大厦.jpg";
        //FileInputStream继承了InputStream，是文件节点流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(from));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(to));
        //为了提高读取效率，定义一个字节数组byte[]
        byte[] buf = new byte[1024];
        int readLen = 0;
        while((readLen = bufferedInputStream.read(buf)) != -1){
            bufferedOutputStream.write(buf,0,readLen);
        }
        //关闭流，只需要关闭处理流即可，节点流会自动关闭
        if(bufferedOutputStream != null) {
            bufferedOutputStream.close();
        }
        if(bufferedInputStream != null) {
            bufferedInputStream.close();
        }
    }
}
