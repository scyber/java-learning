package com.mycompany.java.learning;

/**
 * Created by greg on 22.05.2016.
 */
// Применение конструктора, переменной экземпляра и
// метода в перечислении,
enum TransportEn3 {
    // Обратите внимание на инициализирующие значения констант.
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);

    // Объявление переменной экземпляра.
    private int speed; // обычная скорость каждого транспортного средства

    // Объявление конструктора.
    TransportEn3(int s) { speed = s; }

    // Определение метода.
    int getSpeed() { return speed; }
}

class EnumDemo3 {
    public static void main(String args[])
    {
        TransportEn3 tp;

        // отобразить скорость самолета
        // Скорость определяется с помощью метода getSpeed().
        System.out.println("Typical speed for an airplane is " +
                TransportEn3.AIRPLANE.getSpeed() +
                " miles per hour.\n");

        // отобразить все виды транспорта и скорости их передвижения
        System.out.println("All Transport speeds: ");
        for(TransportEn3 t : TransportEn3.values())
            System.out.println(t + " typical speed is " +
                    t.getSpeed() +
                    " miles per hour.");
    }
}