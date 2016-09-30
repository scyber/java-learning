package com.mycompany.java.learning;

/**
 * Created by gpiskunov on 26.05.2016.
 */
public class AutoBox2 {
// Этот метод принимает параметр типа Integer.
static void m(Integer v) {
        System.out.println("m() received " + v);
        }

// Этот метод возвращает значение типа int.
static int m2() {
        return 10;
        }

// Этот метод возвращает значение типа Integer.
static Integer m3() {
        return 99; // Автоупаковка значения 99 в объект типа Integer.
        }

public static void main(String args[]) {
        // Передача методу m() значения типа int.
        // Метод m() принимает параметр типа Integer,
        // поэтому значение int автоматически упаковывается,
        m(199);

        // Здесь объект ЮЬ получает значение типа int, возвращаемое
        // методом т2(). Это значение автоматически упаковывается,
        // чтобы его можно было присвоить объекту iOb.
        Integer iOb = m2();
        System.out.println("Return value from m2() is " + iOb);

        // А здесь метод m3() возвращает значение типа Integer, которое
        // автоматически распаковывается и преобразуется в тип int.
        int i = m3();
        System.out.println("Return value from m3() is " + i);

        // Здесь методу Math.sqrt() в качестве параметра передается
        // объект iOb, который автоматически распаковывается, а его
        // значение продвигается к типу double, требующемуся для
        // выполнения данного метода.
        iOb = 100;
        System.out.println("Square root of iOb is " + Math.sqrt(iOb));
        }
        }
