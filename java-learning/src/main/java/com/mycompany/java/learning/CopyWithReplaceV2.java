/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java.learning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gpiskunov
 */
public class CopyWithReplaceV2 {
 
     public static void main (String args[]) {
        
        //BufferedReader br ;
        // BufferedWriter bw ;
          
        int i=0, j=0;
        Character ch;
        Character ch1, ch2;
        ch1 = new Character(' ');
        ch2 = new Character('-');
        // FileReader fr = new FileReader("test.txt");
        //FileWriter fw = new FileWriter("test-modify2.txt");
        /*    
        if(args.length !=2 )    {
                System.out.println("Usage: CopyFiles fl to f2");
                return;
            }
        */
        try(BufferedReader br = new BufferedReader (new FileReader("test.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("test-modify2.txt"))) {   
            
            //TODO Read while not meet space
            do {
            i = br.read();
            ch = (char)i;
                if ( ch.equals(ch1) ) {
                        ch = ch2;
                        bw.write(ch);
                    //Write to output file
                    //System.out.print(ch);
                } else {                 
                        // Write to output file
                        bw.write(ch);
                    
                }
                //System.out.println(ch);
            } while (i != -1 );
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(CopyWithReplace.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(CopyWithReplace.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
     }
}
