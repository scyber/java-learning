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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

public class CopyWithReplace {
 
    
    //TODO
    // Create InputStream, OutputStream files
    // Read Byte, compare if a space replace with defis
    
    //TODO
    //Close traditionally the file
    //TODO
    public static void main (String args[]) {
        
        FileInputStream fin = null;
        FileOutputStream fout = null;
        ByteArrayInputStream br = null;
        
        int i=0, j=0;
        /*    
        if(args.length !=2 )    {
                System.out.println("Usage: CopyFiles fl to f2");
                return;
            }
        */
        try {   
            fin = new FileInputStream("test.txt");
            fout = new FileOutputStream("test-modify.txt");
            //TODO Read while not meet space
            do {
            i = fin.read();
            
                if (i != -1) {
                    //If char ==  " "; replace with dash
                    if (  (char)i  != ' ') {
                        // Write to output file
                        fout.write((char) i);
                    } else {
                        char ch;
                        ch = '-';
                        fout.write(ch);
                        // Replace space and write to output file
                    }
                    
                    //Write to output file
                    System.out.print((char) i);
                }
            } while (i!= -1 );
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(CopyWithReplace.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(CopyWithReplace.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fin.close();
                fout.close();
            } catch (IOException ex) {
                Logger.getLogger(CopyWithReplace.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
