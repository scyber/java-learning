package com.mycompany.java.learning;

/**
 * Created by greg on 22.05.2016.
 */
enum TransportEn1 {
    CAR, TRUCK, AIRPLANE, TRAIN, BOAT
}
class EnumDemo2 {
    public static void main(String args[])
    {
        TransportEn1 tp;

        System.out.println("Here are all Transport constants");

        // воспользоваться методом values()
        // Получение массива констант типа Transport.
        TransportEn1 allTransports[] = TransportEn1.values();
        for(TransportEn1 t : allTransports)
            System.out.println(t);

        System.out.println();

        // воспользоваться методом valueOf()
        // Получение константы под названием AIRPLANE.
        tp = TransportEn1.valueOf("AIRPLANE");
        System.out.println("tp contains " + tp);
    }
}