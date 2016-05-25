package com.mycompany.java.learning;

/**
 * Created by gpiskunov on 25.05.2016.
 */
public class QueueThread {
    private char q[];
    private int putloc, getloc;
    QueueThread (int size) {

        q = new char[size + 1];
        putloc = getloc = 0;
    }
    QueueThread (Queue ob ) {
        putloc = ob.putloc;
        getloc = ob.getloc;

        q = new char [ob.q.length];

        for (int i=getloc + 1 ; i <= putloc; i++) {
            q[i] = ob.q[i];
        }
    }

    String state; // содержит сведения о состоянии часов
    synchronized void put(boolean running) {
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

    synchronized void get(boolean running) {
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

class MyThreadQueue implements Runnable {
    Thread thrd;
    TickTockTask ttOb;

    // построить новый поток
    MyThreadQueue (String name, TickTockTask tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
        thrd.start(); // начать поток
    }

    // начать исполнение нового потока
    public void run() {
        if(thrd.getName().compareTo("Tick") == 0) {
            for(int i=0; i<5; i++) {
                try {

                    ttOb.tick(true);
                    thrd.sleep(100);
                } catch (Exception ex ) {
                    ex.printStackTrace();
                }

                try {
                    thrd.sleep(100);
                    ttOb.tick(false);

                } catch (Exception ex ) {
                    ex.printStackTrace();
                }

            }
        }
        else {
            for(int i=0; i<5; i++) ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}

class ThreadRun {
    public static void main(String args[]) {
        TickTockTask tt = new TickTockTask();
        MyThreadTask mtl = new MyThreadTask("Tick", tt);
        MyThreadTask mt2 = new MyThreadTask("Tock", tt);

        try {
            mtl.thrd.join();
            mt2.thrd.join();
        } catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}

