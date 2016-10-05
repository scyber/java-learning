package com.mycompany.java.learning;

/**
 * Created by greg on 09.05.2016.
 */
import java.io.*;
import java.nio.CharBuffer;

public class ReplaceSpaceFromFile {
    // Read From File
    public static void main(String args[]) {
        String s;
        int value;
        char [] getChars = new char[0];
        char [] wrChars = new char[0];

        // Создание в классе BufferedReader оболочки с целью заключить
        // в нее класс FileReader и организовать чтение данных из файла.
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt")))
        {
            // читаем символ если пробел заменяем на -

            while(( value = br.read()) != -1 ) {
                /*

                 */
                char c = (char) value;
                System.out.print(c);
                //
                //
                //
                // System.out.println(s)
                // Replace space char to
                //

            }
        } catch(IOException exc) {
            System.out.println("I/O Error: " + exc) ;
        }
    }

}
