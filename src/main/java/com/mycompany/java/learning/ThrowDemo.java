/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java.learning;

/**
 *
 * @author gpiskunov
 */
public class ThrowDemo {
    public static void main(String args[])  {
            System.out.println("Befor try block start ");
        try {
            System.out.println("Before throw.");
                // Генерирование исключения.
                throw new ArithmeticException() ;
                //System.out.println("This is never print ");
        }
        catch (ArithmeticException exc) {
            // перехватить исключение
            System.out.println("Exception caught.");
        }

        System.out.println("After try/catch block.");
    }
}
