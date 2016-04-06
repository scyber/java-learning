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
class Quicksort {
    static void qsort(char items[]) {
        qs(items, 0, items.length - 1);
    }
    private static void qs (char items[], int left, int right) {
        int i, j;
        char x,y;
        
        i = left;
        j = right;
        
        x = items[(left + right)/2];
        
        do {
            while((items[i] < x) && (i < right)) i++;
            while (x < items[j] && (j > left)) j--;
            
            if(i <= j) {
                y = items[i];
                items[i] = items[j];
                items[j] = y;
                i++; j--;
            }
        } while( i <= j);
        if (left < j) qs(items, left, j);
        if (i < right) qs(items, i, right);
    }
}
class QSDemo {
    
    public static void main (String args[]) {
        char a [] = { 'd', 'x', 'a', 'r', 'p', 'j', 'i', 'a', 'o' };
        int i;
        
        System.out.print("Original array: " );
        for (i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
        
        Quicksort.qsort(a);
        
        System.out.print("Sortet array : ");
        for (i=0; i< a.length; i++){
            System.out.print(a[i]);
        }
    }
}