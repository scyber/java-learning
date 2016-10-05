package com.mycompany.java.learning;

/**
 * Created by gpiskunov on 26.05.2016.
 */
public // Автоупаковка и автораспаковка в выражениях.
class AutoBox3 {
    public static void main(String args[]) {
        Integer iOb, iOb2;
        int i;

        iOb = 99;
        System.out.println("Original value of iOb: " + iOb);

        // В следующем выражении объект iOb автоматически
        // распаковывается, производятся вычисления, а результат
        // снова упаковывается в объект iOb.
        ++iOb;
        System.out.println("After ++iOb: "+ iOb);

                // В последующем выражении производится автораспаковка
                // объекта iOb, к полученному значению прибавляется число 10,
                // а результат снова упаковывается в объект iOb.
                iOb += 10;
        System.out .println ("After iOb +=? 10: " + iOb) ;

        //И в следующем выражении объект iOb автоматически
        // распаковывается, выполняются вычисления, а результат
        // снова упаковывается в объект iOb.
        iOb2 = iOb + (iOb / 3);
        System.out.println("iOb2 after expression: " + iOb2);

        // А в этом случае вычисляется то же самое выражение,
        // но повторная упаковка не производится,
        i = iOb + (iOb / 3);

        System.out.println("i after expression: " + i);
    }
}