package io_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HomeWork02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("E:/2.txt"));
        String line = "";
        int count = 1;
        while ((line = br.readLine()) != null) {
            System.out.println(count + "\t" + line);
            count ++;
        }
        if(br != null) {
            br.close();
        }
    }
}
