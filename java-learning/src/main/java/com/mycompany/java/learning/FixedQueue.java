/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.java.learning;

/**
 *
 * @author gpiskunov
 */
class FixedQueue implements ICharQ {
    private char q[]; // Массив для хранения элементов очереди,
    private int putloc, getloc; // Индексы размещения и извлечения

    // элементов очереди.
    // создать пустую очередь заданного размера
    public FixedQueue(int size) {
        q = new char[size+1]; // выделить память для очереди
        putloc = getloc = 0;
    }

    // поместить символ в очередь
    public void put(char ch)
            throws QueueFullException {

        if(putloc==q.length-1)
            throw new QueueFullException(q.length-1);

        putloc++;
        q[putloc] = ch;
    }

    // извлечь символ из очереди
    public char get()
            throws QueueEmptyException {

        if(getloc == putloc)
            throw new QueueEmptyException();

        getloc++;
        return q[getloc];
    }
}