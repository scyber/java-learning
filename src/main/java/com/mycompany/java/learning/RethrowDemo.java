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
class Rethrow {
    public static void genException()   {
        
 // Массив numer длиннее маесивв denom.
        int numer[] = { 4, 8, 16, 32, 64, 128, 256, 512 };
        int denom[] = { 2, 0, 4, 4, 0, 8 };

        for(int i=0; i<numer.length; i++)   {
            try {
                System.out.println(numer[i] + " / " +
                                   denom[i] + " is " +
                                   numer[i]/denom[i]);
            }
            catch (ArithmeticException exc) {
                // перехватить исключение
                System.out.println("Can11 divide by Zero!");
            }
            catch (Exception exc) {
                // перехватить исключение
                System.out.println("No matching element found.");
                throw exc; // Повторное генерирование исключения.
            }
        }
    }
}         
public class RethrowDemo {
     public static void main(String args[])  {
        try {
            Rethrow.genException();
        }
        catch(Exception exc) {
            // Перехват повторно сгенерированного включения.
            System.out.println("Fatal error - " +
                               "program terminated.");
        } finally {
            System.out.println("This is a finish of run ");
        }
    }
}
