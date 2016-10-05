package com.mycompany.java.learning;

/**
 * Created by gpiskunov on 25.05.2016.
 */
public class AutoBox {
    public static void main(String args[]) {

        // Автоупаковка и автораспаковка значения 100.
        Integer iOb = 100;
        int i = iOb;

        System.out.println(i + " " + iOb); // displays 100 100
    }
}