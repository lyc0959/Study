package io_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Transform {
    public static void main(String[] args) throws IOException {
        String path = "E:/2_ANSI.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = "";
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        if(br != null) {
            br.close();
        }
    }
}
