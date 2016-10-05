/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ch5Demo;

/**
 *
 * @author gpiskunov
 */
public class OrevLoad2 {
    void f(int x) {
        System.out.println("Insight  f (int) " + x);
    }
    void f(double x) {
        System.out.println("Insight f (double) " + x);
    }
    void f (byte x) {
        System.out.println("Insight f (byte) " + x );
    }
    
    public static void main (String args[]) {
        int i = 10;
        double d = 10.2;
        byte b = 16;
        long l = 2131231231;
        float f = 11f;
        
        
        OrevLoad2 ob = new OrevLoad2();
        
        ob.f(i);
        ob.f(d);
        ob.f(b);
        ob.f(l);
        ob.f(f);
    }
}
