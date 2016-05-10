package com.mycompany.java.learning;

/**
 * Created by greg on 16.04.2016.
 */

class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) { size = s; }

    public String toString()    {
        return "\nQueue is full. Maximum size is " + size;
    }
}
// Исключение, указывающее на опустошение очереди,
class QueueEmptyException extends Exception {
    public String toString()    {
        return "\nQueue is empty.";
    }
}

// Демонстрация исключений при обращении с очередью,
class QExcDemo {
    public static void main(String args[])  {
        FixedQueue q = new FixedQueue(20);
        char ch;
        int i;

        try { // Переполнение очереди.
            for(i=0; i < 22; i++)   {
                System.out.print("Attempting to store : " +
                        (char) ('A' + i));
                q.put((char) ('A' + i));
                System.out.println(" - OK");
            }
            System.out.println();
        }
        catch (QueueFullException exc) {
            System.out.println(exc);
        }
        System.out.println();

        try {
            // Попытка извлечь символ из пустой очереди.
            for(i=0; i < 22; i++) {
                System.out.print("Getting next char: ");
                ch = q.get();
                System.out.println(ch);
            }
        }
        catch (QueueEmptyException exc) {
            System.out.println(exc);
        }
    }
}