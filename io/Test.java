package io;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("example.txt")));
            writer = new PrintWriter(new FileOutputStream("example2.txt"));

            for (int i = 1;; ++i) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                writer.println(String.format("%d. %s", i, line));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}