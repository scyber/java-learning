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
