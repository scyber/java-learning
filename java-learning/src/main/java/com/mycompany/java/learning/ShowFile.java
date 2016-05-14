package com.mycompany.java.learning;
import java.io.*;
/* Отображение текстового файла.
При вызове этой программы следует указать имя файла,
содержимое которого требуется просмотреть.
Например, для вывода на экран содержимого файла TEST.TXT,
в командной строке нужно указать следующее:
java ShowFile TEST.TXT
*/
/**
 * Created by greg on 09.05.2016.
 */


public class ShowFile {
    public static void main(String args[])
    {
        int i;
        FileInputStream fin;
// Прежде всего следует убедиться, что файл был указан,
        if(args.length != 1) {
            System.out.println("Usage: ShowFile File");
            return;
        }
        try {
// Открытие файла.
            fin = new FileInputStream(args[0]);
        } catch(FileNotFoundException exc) {
            System.out.println("File Not Found");
            return;
        }
        try {
// читать из файла до тех пор, пока не встретится знак EOF.
            do {
// Чтение из файла.
                i = fin.read();
                if(i != -1) System.out.print((char) i) ;
// Если значение переменной i равно -1,значит,
// достингут конец файла.
            } while (i != -1);
        } catch(IOException exc) {
            System.out.println("Error reading file.");
        }
        try {
// Закрытие файла.
            fin.close ();
        } catch(IOException exc) {
            System.out.println("Error closing file.");
        }
    }
}
