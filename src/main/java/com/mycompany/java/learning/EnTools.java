package com.mycompany.java.learning;

import javax.tools.Tool;

/**
 * Created by gpiskunov on 27.05.2016.
 */
enum Tools {
    SCREWDRIVER, WRENCH, HAMMER, PLIERS
}
public class EnTools {

    public  static void main (String args[]) {
        Tools tl;
        for (Tools t : Tools.values()) {
            System.out.println("This is a tool " + t);
        }
    }

}
