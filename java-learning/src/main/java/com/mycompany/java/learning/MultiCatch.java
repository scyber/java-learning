package com.mycompany.java.learning;

/**
 * Created by greg on 16.04.2016.
 */
public class MultiCatch {

    public static void main(String args[]) {
        int a=88, b=0;
        int result;
        char chrs[] = { 'А', 'В', 'C' };

        for(int i=0; i < 2; i++)
            try {
                if (i == 0)
                    // сгенерировать исключение ArithmeticException
                    result = a / b;
                else
                    // сгенерировать исключение ArraylndexOutOfBoundsException
                    chrs[5] = 'X';
            }
            // В этом операторе catch организуется перехват обоих исключений,
            catch (ArithmeticException | ArrayIndexOutOfBoundsException е) {
                        е.printStackTrace();
                        System.out.println();
                        //System.out.println("Exception caught: " + еxc.toString() );

            }

        System.out.println("After multi-catch.");
    }
}
