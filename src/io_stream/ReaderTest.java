package io_stream;

import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
    public static void main(String[] args) {
        String path = "E:/2.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            int data = 0;//读取的字符
            while((data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
