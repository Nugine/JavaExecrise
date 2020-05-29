package io;

import java.io.*;
import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("test3.txt");
            PrintWriter writer = new PrintWriter(fileOutput);

            List<Long> nums = new ArrayList<Long>();
            for (int i = 1; i <= 20; ++i) {
                nums.add(1L);
                for (int j = nums.size() - 2; j >= 1; --j) {
                    nums.set(j, nums.get(j - 1) + nums.get(j));
                }
                for (long x : nums) {
                    writer.write(x + " ");
                }
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}