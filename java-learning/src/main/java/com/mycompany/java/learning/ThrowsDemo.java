<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java.learning;
import java.io.*;
/**
 *
 * @author gpiskunov
 */
class ThrowsDemo {
    // Обратите внимание на оператор throws в объявлении метода.
    public static char prompt(String str)
        throws IOException {
=======
package com.mycompany.java.learning;
import java.io.*;
/**
 * Created by greg on 16.04.2016.
 */
public class ThrowsDemo {
    public static char prompt(String str)
            throws IOException {
>>>>>>> b3c1b9e4d50acd76b42fde215c707e4cf25c0d4d

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
