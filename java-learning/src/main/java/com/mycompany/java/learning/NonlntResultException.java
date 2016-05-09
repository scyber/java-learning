package com.mycompany.java.learning;

/**
 * Created by greg on 16.04.2016.
 */
class NonlntResultException extends Exception {
    int n;
    int d;

    NonlntResultException  (int i, int j) {
        n = i;
        d = j;
    }

    public String toString()    {
        return "Result of " + n + " / " + d +
                " is non-integer.";
    }
}

class CustomExceptDemo {
    public static void main(String args[]) {

        // В массиве numer содержатся нечетные числа,
        int numer[] = { 4, 8, 15, 32, 64, 127, 256, 512 };
        int denom[] = { 2, 0, 4, 4, 0, 8 };
        for(int i=0; i<numer.length; i++)   {
            try {
                if((numer[i]%2) != 0)throw new NonIntResultException (numer[i], denom[i]);
                System.out.println(numer[i] + " / " +
                                denom[i] + " is " +
                        numer[i]/denom[i]);
            }
            catch (ArithmeticException exc) {
                // перехватить исключение
                System.out.println("Can11 divide by Zero!");
            }
            catch (ArrayIndexOutOfBoundsException exc) {
                // перехватить исключение
                System.out.println("No matching element found.");
            }
            catch (NonIntResultException exc) {
                System.out.println(exc) ;
            }
        }
    }
}
