package com.mycompany.java.learning;

/**
 * Created by greg on 14.05.2016.
 */
// Применение синхронизированного блока
// для управления доступом к методу sumArray().
class SumArrayModify {
    private int sum;

    // Здесь метод sumArray () не синхронизирован.
    int sumArray(int nums[]) {
        sum =0; // обнулить сумму
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("Running total for " +
                    Thread.currentThread().getName() +
                    " is " + sum);
            try {
                Thread.sleep(10); // разрешить переключение задач
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThreadModify implements Runnable {
    Thread thrd;
    static SumArrayModify sa = new SumArrayModify();
    int a[];
    int answer;

    // построить новый поток
    MyThreadModify(String name, int nums[]) {
        thrd = new Thread(this, name);
        a = nums;
        thrd.start(); // начать поток
    }

    // начать исполнение нового потока
    public void run() {
        int sum;

        System.out.println(thrd.getName() + " starting.");

        // Здесь вызовы метода sumArray () для объекта sa синхронизированы.
        synchronized(sa) {
            answer = sa.sumArray(a);
        }
        System.out.println("Sum for " + thrd.getName() +
                " is " + answer);
        System.out.println(thrd.getName() + " terminating.");
    }
}
public class SyncModify {
    public static void main(String args[]) {
        int a [] = {1, 2, 3, 4, 5};

        MyThreadModify mtl = new MyThreadModify("Child #1", a);
        MyThreadModify mt2 = new MyThreadModify("Child #2", a);

        try {
            mtl.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
