package com.mycompany.java.learning;

/**
 * Created by greg on 15.05.2016.
 */
// Приостановка, возобновление и остановка потока.
class MyThreadExt2 implements Runnable {
    Thread thrd;

    // Если эта переменная принимает логическое значение
    // true, исполнение потока приостанавливается.
    volatile boolean suspended;
    // Если эта переменная принимает логическое значение
    // true, исполнение потока прекращается.
    volatile boolean stopped;

    MyThreadExt2(String name) {
        thrd = new Thread(this, name);
        suspended = false;
        stopped = false;
        thrd.start();
    }

    // Точка входа в поток
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        try {
            for(int i = 1; i < 1000; i++) {
                System.out.print(i + " ");
                if((i %10)==0) {
                    System.out.println() ;
                    Thread.sleep(250) ;
                }

                // Для проверки условий приостановки и остановки потока
                // используется следужхций синхронизированный блок.
                synchronized(this) {
                    while(suspended) {
                        wait();
                    }
                    if(stopped) break;
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thrd.getName() + " interrupted.");
        }
        System.out.println(thrd.getName() + " exiting.");
    }

    // остановить поток
    synchronized void mystop() {
        stopped = true;

        // Следующие операторы обеспечивают полную
        // остановку приостановленного потока,
        suspended = false;
        notify();
    }

    // приостановить поток
    synchronized void mysuspend() {
        suspended = true;
    }

    // возобновить поток
    synchronized void myresume() {
        suspended = false;
        notify();
    }
}

class Suspend {
    public static void main(String args[]) {
        MyThreadExt2 obi = new MyThreadExt2("My Thread");

        try {
            Thread.sleep(1000); // позволить потоку оЫ начать исполнение

            obi.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            obi.myresume();
            System.out.println("Resuming thread.");
            Thread.sleep(1000);

            obi.mysuspend();
            System.out.println("Suspending thread.");
            Thread.sleep(1000);

            obi.myresume();
            System.out.println("Resuming thread.") ;
            Thread.sleep(1000);

            obi.mysuspend() ;
            System.out.println("Stopping thread.");
            obi.mystop();
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        // ожидать завершения потока
        try {
            obi.thrd.join() ;
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}