package com.mycompany.java.learning;

/**
 * Created by greg on 09.05.2016.
 */
import java.io.*;
public class ReadBytes {
    public static void main(String args[])
            throws IOException {
        byte data[] = new byte[10];

        System.out.println("Enter some characters.");
        // Чтение данных, введенных с клавиатуры,
        // и размещение их в байтовом массиве.
        System.in.read(data);
        System.out.print("You entered: ");
        for(int i=0; i < data.length; i++)
            System.out.print((char) data[i]);
    }
}
