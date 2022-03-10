package io_stream;

import java.io.File;
import java.io.IOException;

public class HomeWork01 {
    public static void main(String[] args) {
        File file = new File("E:/mytemp");
        if (!file.exists()) {
            file.mkdir();
        }
        File hello = new File("E:/mytemp/hello.txt");
        try {
            if (hello.exists()) {
                System.out.println("hello文件已存在!");
            } else {
                hello.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
