package io_stream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter01 {
    public static void main(String[] args) {
        String path = "E:/2.txt";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
            fileWriter.write("风雨之后见彩虹！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();//一定要关闭或者flush才能将内容写入文件
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
