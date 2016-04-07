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
class ByTrees implements Series {
    int start;
    int val;
    
    ByTrees() {
    start = 0;
    val = 0;
    }
    public int getNext() {
        val += 3;
        return val;
    }
    public void reset() {
        start = 0;
        val = 0;
    }
    public void setStart(int x) {
        start = x;
    }
    
}
