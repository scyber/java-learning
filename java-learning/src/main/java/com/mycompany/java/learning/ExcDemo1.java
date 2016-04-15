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
class ExcDemo1 {

    public static void main (String args[]) {
        int nums[] = new int[4];

        // Создание блока try.
        try {
            System.out.println("Before exception is generated.");

            // Попытка обратиться за границы массива.
            nums[7] = 10;
            System.out.println("this won't be displayed");
        }
        // Перехват исключения в связи с обращением за границы массива.
        catch (Exception exc) {
            System.out.println("Index out-of-bounds!");
        }
        System.out.println("After catch statement.");
    }
    
}
