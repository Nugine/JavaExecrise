package io;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutput = new FileOutputStream("test.txt");
            DataOutputStream dataOutput = new DataOutputStream(fileOutput);
            dataOutput.writeInt(123);
            dataOutput.writeDouble(4.56);
            dataOutput.writeLong(789L);
            dataOutput.writeBoolean(true);
            dataOutput.writeUTF("abc");
            dataOutput.close();

            FileInputStream fileInput = new FileInputStream("test.txt");
            DataInputStream dataInput = new DataInputStream(fileInput);
            System.out.println(dataInput.readInt());
            System.out.println(dataInput.readDouble());
            System.out.println(dataInput.readLong());
            System.out.println(dataInput.readBoolean());
            System.out.println(dataInput.readUTF());
            dataInput.close();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}