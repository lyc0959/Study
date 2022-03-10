package io_stream;

import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        System.out.println(System.in.getClass());
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.next());
    }
}
