package io_stream;

import java.io.FileReader;
import java.io.IOException;

public class FileReader02 {
    public static void main(String[] args) {
        String path = "E:/2.txt";
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            char[] buf = new char[8];//提高读取效率，定义每次读取8个字符放入字符数组
            int readLen = 0;
            while((readLen = fileReader.read(buf)) != -1){
                //readLen是实际读取的字符数，不能保证每次读取的都是8个，因此要指定字符数组的范围从0-实际读取个数
                System.out.print(new String(buf,0,readLen));
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
