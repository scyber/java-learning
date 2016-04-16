package com.mycompany.java.learning;
import java.io.*;
/**
 * Created by greg on 16.04.2016.
 */
public class ThrowsDemo {
    public static char prompt(String str)
            throws IOException {

        System.out.print(str + ": ");
        return (char) System.in.read() ;
    }

    public static void main(String args[]) {
        char ch;

        try {
            // В методе prompt () может быть сгенерировано исключение,
            // поэтому данный метод следует вызывать в блоке try.
            ch = prompt("Enter a letter");
        }
        catch(IOException exc) {
            System.out.println("I/O exception occurred.");
            ch = 'X';
        }
        System.out.println("You pressed " + ch);
    }
}
