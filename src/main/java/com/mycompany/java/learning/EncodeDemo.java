/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mycompany.java.learning;

/**
 *
 * @author gpiskunov
 */
public class EncodeDemo {
    
    public static void main (String args[]){
        String msg = "This is a text";
        String encmsg = "";
        String decmsg = "";
        
        int key = 88;
        System.out.print("Original message : ");
        System.out.print(msg);
        System.out.println();
        
        for (int i = 0; i < msg.length(); i++) {
            encmsg = encmsg + (char) (msg.charAt(i) ^ key);
            
        }
        System.out.print("Encoded message:  ");
        System.out.print(encmsg);
        System.out.println();
    
    
    for (int i = 0; i < msg.length(); i++ ) {
        decmsg = decmsg + (char) (encmsg.charAt(i) ^ key);
    }
        System.out.print("Decoded message : ");
        System.out.print(decmsg);
        System.out.println();
    }
    
}
