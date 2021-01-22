package Ivan.com;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //firstTask();
        //secondTask();
        thirdTask();
    }

    public static void firstTask () {
        /* 1 Написать метод, который меняет два элемента массива местами.(массив может быть
        любого ссылочного типа);*/
        Scanner input = new Scanner(System.in);
        String[] array = {"hello", "world", "guys"}; //массив строк (может быть и массив любых ссылочных типов -
        // Integer, Double... но не int, double!)
        System.out.println("What indexes do you want to change?");
        int index1 = input.nextInt(); //элементы под индексами index1 и index2 в массиве меняются местами
        int index2 = input.nextInt();
        System.out.println("Initial array: " + Arrays.toString(array));
        swapElements(array, index1, index2); //метод меняющий элементы местами
        System.out.println("Transformed array: " + Arrays.toString(array));
    }

    public static void secondTask() {
        // 2 Написать метод, который преобразует массив в ArrayList;
        String[] array = {"abc", "aka", "789"}; //задали массив строк
        List<String> list = convertToList (array); //объявляем список list элементов типа String и применяем к массиву
        //array метод convertToList который возвращает уже список преобразованный из массива
        System.out.println("Array transformed to list: " + list);
    }

    public static void thirdTask() {
        /*3 Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну
        коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов
        и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую
        коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны,
        false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
        фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
        а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/
        Box<Apple> boxApple = new Box<>(); //создали объект класса Box в котором хранятся элементы типа Apple
        Box<Orange> boxOrange = new Box<>(); //создали объект класса Box в котором хранятся элементы типа Orange
        Box<Orange> boxOrange2 = new Box<>(); //объект boxOrange2 нужен для метода putFruit (в него мы будем класть
        //фрукты из boxOrange)
        Apple apple = new Apple(); //создали объект класса Apple

        boxApple.addFruit(apple); //добавили в объект boxApple класса Box<Apple> объект apple
        boxApple.addFruit(apple);
        boxApple.addFruit(apple); //теперь в boxApple 3 яблока
        System.out.println("Here is the weight of box with apples: " + boxApple.getWeight());

        Orange orange = new Orange();

        boxOrange.addFruit(orange);
        boxOrange.addFruit(orange); //в объекте boxOrange класса Box<Orange> теперь 2 апельсина
        System.out.println("Here is the weight of box with oranges: " + boxOrange.getWeight());

        System.out.println("Weight of boxes with apples and oranges is equal: " + boxApple.compare(boxOrange));
        // метод compare - это метод класса Box. Мы этот метод вызываем у объекта boxApple, в аргументы метода поступает
        // объект с весом которого нужно сравнить вес boxApple
        boxOrange.putFruit(boxOrange2); //метод putFruit примененный к объекту boxOrange берет из него все фрукты,
        //добавляет их в boxOrange2 - парметр метода, а из boxOrange стирает все что было
        System.out.println("Weight of box to which you've put fruits: " + boxOrange2.getWeight());
        System.out.println("Weight of box from which you've taken fruits: " + boxOrange.getWeight());
    }

    public static <T> void swapElements (T[] array, int index1, int index2) { //обобщенный метод перед возвращаемым
        //значением нужно указать в угловых скобках универсальный параметр
        //Затем внутри метода все значения типа T будут представлять данный универсальный параметр.
        T buffer = array[index1]; //массив объявляем внутри метода типа Т
        array[index1] = array[index2];
        array[index2] = buffer;
    }

    public static <E> List<E> convertToList (E[] array) { //<T> - указывается перед возвращаемым параметром универсальный
        //параметр, возвращаемое значение в данном случае List<T>,т.е. список из элементов типа Т
        //на вход в параметры мы получаем массив типа T[]
        return Arrays.asList(array); //метод Arrays.asList() преобразует массив получаемый на вход в список
        //пример: String[] arr = {"abc", "def"};
        //        System.out.println(Arrays.asList(arr)); //выводит [abc, def]
    }
}
