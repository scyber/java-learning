package com.mycompany.java.learning;

/**
 * Created by greg on 09.05.2016.
 */
import java.io.*;
public class CompFiles {

    public static void main(String args[])
    {
        int i=0, j=0;

        // Прежде всего следует убедиться, что файлы были указаны,
        if(args.length !=2 )    {
            System.out.println("Usage: CompFiles fl f2");
            return;
        }

        // сравнить файлы
        try (FileInputStream f1 = new FileInputStream(args[0]);
             FileInputStream f2 = new FileInputStream(args[1]);)
        {
            // проверить содержимое каждого файла
            do {
                i = f1.read();
                j = f2.read();
                if(i != j) break;
            }   while (i != -1 && j != -1) ;

            if(i != j)
                System.out.println("Files are different");
            else
                System.out.println("Files are the same.");
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
