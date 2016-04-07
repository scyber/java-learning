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

 class ByTwos implements Series {
    int start;
    int val;
    
    ByTwos () {
        start = 0;
        val = 0;
    }

    //@Override
    public int getNext() {
        val += 2;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void reset() {
        start = 0;
        val = 0;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public void setStart(int x) {
        start = x;
        val = x;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
class SeriesDemo {
    
    public static void main (String args[]) {
        ByTwos ob = new ByTwos();
        for (int i = 0; i< 5; i++) {
            System.out.println("Next value is " + ob.getNext());
            System.out.println("Resetting ");
            ob.reset();
        }
        for (int i =0; i< 5; i++) {
            System.out.println("Next value is " + ob.getNext());
        }
    }
}
