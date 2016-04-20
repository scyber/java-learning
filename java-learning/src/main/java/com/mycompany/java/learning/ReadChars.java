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
public class ReadChars {
    public static void main(String args[]) throws IOException
  {
    char c;
    // Создание объекта типа BufferedReader, связанного
    // с потоком стандартного ввода System.in.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in) ) ;

    System.out.println("Enter characters, period to quit.");

    // читать символы
    do {
      c = (char) br.read();
      System.out.println(c) ;
    } while(c != '.');
  }
}
