package com.mycompany.java.learning;

/**
 * Created by greg on 14.05.2016.
 */
class MyMultiThread implements Runnable {
    Thread thrd;
    // построить новый поток
    MyMultiThread(String name) {
        thrd = new Thread(this, name);

        thrd.start(); // начать поток
    }
    // начать исполнение нового потока
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrd.getName() +
                        ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " terminating.");
    }
}

class MoreThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        // Создание и запуск на исполнение трех потоков.
        MyMultiThread mtl = new MyMultiThread("Child #1");
        MyMultiThread mt2 = new MyMultiThread("Child #2");
        MyMultiThread mt3 = new MyMultiThread("Child #3");

        for (int i=0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}