package com.mycompany.java.learning;

/**
 * Created by gpiskunov on 30.05.2016.
 */
// Простой обобщенный класс.
// Здесь Т - это параметр типа, заменяемый именем
// подлинного типа при создании объекта класса Gen.

//В объявлении этого класса Т означает обобщенный тип.
class Gen<T> {
    T ob; // объявить объект типа Т
    // передать конструктору ссылку на объект типа Т.
    Gen (T o) {
        ob = o;
    }

    // возвратить объект ob из метода
    T getob() {
        return ob;
    }

    // отобразить тип Т
    void showType() {
        System.out.println("Type of T is " +
                ob.getClass().getName());
    }
}

// продемонстрировать обобщенный класс
class GenDemo {
    public static void main(String args[]) {
        // Создание ссылки на объект типа Gen<Integer>.
        Gen<Integer> iOb;

        // Создать объект типа Gen<Integer> и присвоить ссылку на
        // него переменной iOb. Обратите внимание на автоупаковку при
        // инкапсуляции значения 88 в объекте типа Integer.
        iOb = new Gen<Integer>(88); // получить экземпляр типа Gen<Integer>

        // отобразить тип данных, используемых в объекте iOb
        iOb.showType();

        // Получение значения из объекта iOb. Обратите внимание
        // на то,что приведение типов здесь не требуется,
        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Создание объекта типа Gen для символьных строк.
        // Здесь создается ссылка и сам объект типа Gen<String>.
        Gen<String> strOb = new Gen<String>("Generics Test");

        // отобразить тип данных, используемых в объекте strOb
        strOb.showType();

        // Получение значения из объекта strOb.
        //И здесь приведение типов не требуется.
        String str = strOb.getob();
        System.out.println("value: " + str) ;
    }
}
