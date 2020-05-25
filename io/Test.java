package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Test {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("example.txt")));
            PrintWriter writer = new PrintWriter(new FileOutputStream("example2.txt"));

            for (int i = 1;; ++i) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                writer.println(String.format("%d. %s", i, line));
                writer.flush();
            }
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}