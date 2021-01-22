package Ivan.com;

public class Apple extends Fruits {
    public Apple() { //в конструкторе при создании объекта класса Apple присваивается каждому объекту вес 1
        super.weight = 1.0F; //слово super обозначает что мы переопределяем переменную weight из родительского класса
    }
}
