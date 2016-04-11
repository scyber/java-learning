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
class FixedQueue implements ICharQ{
    
    private char q[];
    private int putloc, getloc;
    
    public FixedQueue (int size) {
        q = new char [size + 1];
        putloc = getloc = 0;
    }
    
    public void put(char ch) {
        if ( putloc == q.length - 1 ) {
            System.out.println(" Queue is full ");
            return;
        }
        putloc++;
        q[putloc] = ch;
        
    }
    public char get() {
        
        if(getloc == putloc ){
        System.out.println(" Queue is empty .");         
        
        return (char) 0 ;
        }
        getloc++;
        return q[getloc];
    }
}
