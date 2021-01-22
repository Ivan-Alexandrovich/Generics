package Ivan.com;

import java.util.ArrayList;

public class Box<T extends Fruits> { //<T> - универсальный параметр, обозначает что мы определяем обобщенный класс Box и
    // далее везде будет фигурировать тип переменных Т
    ArrayList<T> fruitBox = new ArrayList<>(); //список fruitBox объектов типа <T>
    float currentWeight = 0; //поле currentWeight отвечает за текущий вес коробки

    void addFruit(T fruit) {
        fruitBox.add(fruit); //при добавлении фрукта мы в список fruitBox добавляем объект fruit типа Т из параметров
        currentWeight += fruit.weight; //при добавлении фрукта в корзину нужно увеличить вес корзины на вес фрукта
    }

    float getWeight() {
        return currentWeight;
    } //метод возвращает текущий вес коробки

    boolean compare (Box box) { //метод возвращает true если вес коробки к которой применен метод
        return (this.currentWeight == box.currentWeight); //равен весу коробки из параметров
    }

    void putFruit(Box<T> box) {
        box.fruitBox.addAll(this.fruitBox); //весь список нашей коробки добавляем в список объекта box
        this.fruitBox.clear(); //теперь список фруктов в нашей коробке пуст
        box.currentWeight = this.currentWeight;  //в поле текущий вес коробки параметров записываем текущий вес коробки
        //к которой применяем метод
        this.currentWeight = 0; //а вес текущей коробки к которой применяем метод обнуляем
    }
}
