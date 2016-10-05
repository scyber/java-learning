package com.mycompany.java.learning;

/**
 * Created by greg on 22.05.2016.
 */
// Применение методов ordinal() и compareTo().

// Перечисление разных видов транспорта,
enum TransportEn4 {
    CAR, TRUCK, AIRPLANE, TRAIN, BOAT
}

class EnumDemo4 {
    public static void main(String args[])
    {
        TransportEn4 tp, tp2, tp3;

        // получить все порядковые значения с помощью метода ordinal()
        System.out.println("Here are all Transport constants" +
                " and their ordinal values: ");

        for(TransportEn4 t : TransportEn4.values())
            // Получение порядковых значений констант.
            System.out.println(t + " " + t.ordinal());

        tp = TransportEn4.AIRPLANE;
        tp2 = TransportEn4.TRAIN;
        tp3 = TransportEn4.AIRPLANE;

        System.out.println();

        // продемонстрировать применение метода сошрагеТо()
        // Сравнение порядковых значений констант.
        if(tp.compareTo(tp2) < 0)
            System.out.println(tp + " comes before " + tp2) ;

        if(tp.compareTo(tp2) > 0)
            System.out.println(tp2 + " comes before " + tp);

        if(tp.compareTo(tp3) == 0)
            System.out.println(tp + " equals " + tp3);
    }
}