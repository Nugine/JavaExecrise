package io;

import java.io.*;

public class Test4 {
    public static void main(String[] args) {
        FileOutputStream out = null;
        FileInputStream in = null;
        try {
            out = new FileOutputStream("hello.txt");
            byte[] content = "ABCDEFG".getBytes();
            out.write(content);

            in = new FileInputStream("hello.txt");
            byte[] tom = new byte[3];

            StringBuffer bufferOne = new StringBuffer();
            StringBuffer bufferTwo = new StringBuffer();
            int m;
            while ((m = in.read(tom, 0, 3)) != -1) {
                String s1 = new String(tom, 0, m);
                bufferOne.append(s1);
                String s2 = new String(tom, 0, 3);
                bufferTwo.append(s2);
            }
            System.out.println(bufferOne);
            System.out.println(bufferTwo);
        } catch (IOException e) {
        } finally {
            try {
                out.close();
            } catch (IOException e) {
            }
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }
}