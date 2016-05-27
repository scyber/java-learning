package com.mycompany.java.learning;

/**
 * Created by greg on 22.05.2016.
 */
// Имитация автоматизированного светофора с помощью
// перечисления, описывающего переключаемые цвета светофора.

// Перечисление, представляющее состояния светофора,
enum TrafficLightColor {
    RED, GREEN, YELLOW
}

// Имитация автоматизированного светофора,
class TrafficLightSimulator implements Runnable {
    private Thread thrd; // Поток для имитации светофора
    private TrafficLightColor tic; // Текущий цвет светофора
    boolean stop = false; // Остановка имитации, если истинно
    boolean changed = false; // Переключение светофора, если истинно

    TrafficLightSimulator(TrafficLightColor init) {
        tic = init;

        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator() {
        tic = TrafficLightColor.RED;

        thrd = new Thread(this);
        thrd.start();
    }

    // Запуск имитации автоматизированного светофора,
    public void run() {
        while(!stop) {

            try {
                switch(tic) {
                    case GREEN:
                        Thread.sleep(10000); // Зеленый на 10 секунд
                        break;
                    case YELLOW:
                        Thread.sleep(2000); // Желтый на 2 секунды
                        break;
                    case RED:
                        Thread.sleep(12000); // Красный на 12 секунд
                        break;
                }
            } catch(InterruptedException exc) {
                System.out.println(exc);
            }
            changeColor() ;
        }
    }

    // Переключение цвета светофора,
    synchronized void changeColor() {

        switch(tic) {
            case RED:
                tic = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tic = TrafficLightColor.RED;
                break;
            case GREEN:
                tic = TrafficLightColor.YELLOW;
        }

        changed = true;
        notify(); // уведомить о переключении цвета светофора
    }

    // Ожидание переключения цвета светофора.
    synchronized void waitForChange() {
        try {
            while(!changed)
                wait(); // ожидать переключения цвета светофора
            changed = false;
        } catch(InterruptedException exc) {
            System.out.println(exc);
        }
    }

    // Возврат текущего цвета.
    TrafficLightColor getColor() {
        return tic;
    }

    // Прекращение имитации светофора,
    void cancel() {
        stop = true;
    }
}

class TrafficLightDemo {
    public static void main(String args[]) {
        TrafficLightSimulator tl =
                new TrafficLightSimulator(TrafficLightColor.GREEN);

        for (int i=0; i < 9; i++) {
            System.out.println(tl.getColor());
            tl.waitForChange();
        }
        tl.cancel();
    }
}