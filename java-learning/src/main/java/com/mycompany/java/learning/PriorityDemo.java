package com.mycompany.java.learning;

/**
 * Created by greg on 14.05.2016.
 */
// Демонстрация потоков с разными приоритетами.
class Priority implements Runnable {
    int count;
    Thread thrd;

    static boolean stop = false;
    static String currentName;

    /* Построение нового потока. Обратите внимание на то,
       что конструктор не запускает поток на исполнение. */
    Priority(String name) {
        thrd = new Thread(this, name);
        count = 0;
        currentName = name;
    }

    // начать исполнение нового потока
    public void run() {
        System.out.println(thrd.getName() + " starting.");
        do {
            count++;

            if(currentName.compareTo(thrd.getName())    !=  0)  {
                currentName = thrd.getName();
                System.out.println("In " + currentName);
            }
            // Первый же поток, в котором достигнуто значение 10000000,
            // завершает остальные потоки.
        } while(stop == false && count < 10000000);
        stop = true;

        System.out.println("\n" + thrd.getName() +
                " terminating.");
    }
}

class PriorityDemo {
    public static void main(String args[]) {
        Priority mtl = new Priority("High Priority");
        Priority mt2 = new Priority("Low Priority");

        // задать приоритеты
        // Поток mtl получает более высокий приоритет, чем поток mt2.
        mtl.thrd.setPriority(Thread.NORM_PRIORITY+3);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY-3);

        // запустить потоки на исполнение
        mtl.thrd.start();
        mt2.thrd.start();

        try {
            mtl.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
        System.out.println("\nHigh priority thread counted to " +
                mtl.count);
        System.out.println("Low priority thread counted to " +
                mt2.count);
    }
}
