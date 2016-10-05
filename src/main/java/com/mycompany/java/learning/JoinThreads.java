package com.mycompany.java.learning;

/**
 * Created by greg on 14.05.2016.
 */
// Применение метода join().
class MyThreadNew implements Runnable {
    Thread thrd;

    // построить новый поток
    MyThreadNew(String name) {
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

class JoinThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");

        MyThreadNew mtl = new MyThreadNew("Child #1");
        MyThreadNew mt2 = new MyThreadNew("Child #2");
        MyThreadNew mt3 = new MyThreadNew("Child #3");

        try {
            // Ожидание до тех nop, пока указанный метод не завершится.
            mtl.thrd.join();
            System.out.println("Child #1 joined.");
            mt2.thrd.join() ;
            System.out.println("Child #2 joined.");
            mt3.thrd.join();
            System.out.println("Child #3 joined.");
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("Main thread ending.");
    }
}
