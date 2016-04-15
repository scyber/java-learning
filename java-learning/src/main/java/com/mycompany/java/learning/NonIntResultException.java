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
class NonIntResultException extends Exception {
    
    int n, d;
    
    NonIntResultException (int i, int j) {
        n = i;
        d = j;
              
    }
    public String toString() {
        return "Result of " + n + " / " + d + " is non integer ";
    }
}
class CustomExceptionDemo {
    
    public static void main (String args []) {
        
        int numer[] = {4, 8, 15, 32, 64, 127, 256, 512};
        int denom[] = {2, 0, 4, 4, 0, 8};
        
        for (int i =0; i< numer.length; i++) {
            
            try {
                if((numer[i]%2 != 0)) throw new NonIntResultException (numer[i], denom[i]);
                System.out.println(numer[i] + " / " + denom[i] +  " is " + numer[i] / denom[i] );
            } catch ( ArithmeticException exc ) {
                System.out.println("Cann't divide by Zero !");
            } 
            catch (NonIntResultException exc) {
                System.out.println(exc);
                
            }
        }  
    }
}