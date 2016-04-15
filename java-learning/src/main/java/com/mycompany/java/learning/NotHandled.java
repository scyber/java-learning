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
public class NotHandled {
    public static void main(String args[]) {
        int nums[] = new int[4];

        System.out.println("Before exception is generated.");

        // Попытка обращения за границы массива,
        nums[7] = 10;
    }
}
