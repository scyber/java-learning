package com.mycompany.java.learning;

/**
 * Created by greg on 10.05.2016.
 */
class MyThread implements Runnable {
    String thrdName;

    // Объекты типа MyThread выполняются в отдельных потоках, так как
    // класс MyThread реализует интерфейс Runnable.
    MyThread(String name) {
        thrdName = name;
    }

    // Точка входа в поток,
    public void run() {
        // Здесь начинают исполняться потоки.
        System.out.println(thrdName + " starting.");
        try {
            for(int count=0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("In " + thrdName +
                        ", count is " + count);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thrdName + " interrupted.");
        }
        System.out.println(thrdName + " terminating.");
    }
}
public class UseThreads {
    public static void main(String args[]) {
        System.out.println("Main thread starting.");
        // сначала построить объект типа MyThread
        MyThread mt = new MyThread("Child #1"); // Создание исполняемого объекта.
        // далее сформировать поток из этого объекта
        Thread newThrd = new Thread(mt); // Формирование потока из этого объекта.
        // и, наконец, начать исполнение потока

        newThrd.start();  // Начало исполнения потока.
        for(int i=0; i<50; i++) {
            System.out.print(".") ;
            try {
                Thread.sleep(100) ;
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        System.out.println("Main thread ending.");
    }
}
