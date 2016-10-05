package com.mycompany.java.learning;

/**
 * Created by greg on 15.05.2016.
 */
// Применение методов wait() и notifyO для имитации часов,
class TickTock {
    String state; // содержит сведения о состоянии часов
    synchronized void tick(boolean running) {
        if (!running) { // остановить часы
            state = "ticked";
            notify(); // уведомить ожидающие потоки
            return;
        }

        System.out.print("Tick ");

        state = "ticked"; // установить текущее состояние после такта "тик"
        notify();         // Метод tick() уведомляет метод tock()
        // о возможности продолжить выполнение.
        try {
            while(!state.equals("tocked") )
                wait();// Метод tick() ожидает завершения метода tock().
        }
        catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }

    synchronized void tock(boolean running) {
        if(!running) { // остановить часы
            state = "tocked";
            notify(); // уведомить ожидающие потоки
            return;
        }

        System.out.println("Tock");

        state = "tocked"; // установить текущее состояние после такта "так"
        notify(); // Метод tock() уведомляет метод tick()
        // возможности продолжить выполнение.
        try {
            while(!state.equals("ticked") )
                wait(); // Метод tock() ожидает завершения метода tick().
        }
        catch(InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
    }
}

class MyThreadExt implements Runnable {
    Thread thrd;
    TickTock ttOb;

    // построить новый поток
    MyThreadExt (String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start(); // начать поток
    }

    // начать исполнение нового потока
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i=0; i<5; i++) ttOb.tick(true);
            ttOb.tick(false);
        }
        else {
            for(int i=0; i<5; i++) ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String args[]) {
        TickTock tt = new TickTock();
        MyThreadExt mtl = new MyThreadExt("Tick", tt);
        MyThreadExt mt2 = new MyThreadExt("Tock", tt);

        try {
            mtl.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
