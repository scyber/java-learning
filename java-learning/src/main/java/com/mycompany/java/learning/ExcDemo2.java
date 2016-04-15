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
class ExcTest {

    // сгенерировать исключение
    static void genException()  {
        int nums[] = new int[4];

        System.out.println("Before exception is generated.");

        // Здесь генерируется исключение в связи с
        // обращением за границы массива.
        nums[7] = 10;
        System.out.println("this won't be displayed");
    }
}

class ExcDemo2 {
    public static void main(String args[])  {
        try {
            ExcTest.genException() ;
        }
        //А здесь исключение перехватывается.
        catch (Exception exc) {
            System.out.println("Index out-of-bounds!");
        }
        System.out.println("After catch statement.");
    }
}
