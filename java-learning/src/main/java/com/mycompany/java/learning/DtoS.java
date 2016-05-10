package com.mycompany.java.learning;

/**
 * Created by greg on 09.05.2016.
 */
import java.io.*;

public class DtoS {

    public static void main(String args[]) {
        String s;
        // Создание в классе BufferedReader оболочки с целью заключить
        // в нее класс FileReader и организовать чтение данных из файла.
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt")))
        {
            while((s = br.readLine())   !=  null) {
                System.out.println(s) ;
            }
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc) ;
        }
    }
}
