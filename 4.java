/*
Блажеев Кирилл Б763-2
Вариант А
2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.
*/
import java.security.PublicKey;
import java.util.PrimitiveIterator;

class Main{
    public static void main(String[] args){

        Car car = new Car();
        car.checkMark();
        car.refuel();
        car.changeWheel();
        car.drive();
    }
}




class Engine{
        private String engine;
        public Engine(String engine ){
            this.engine = engine;
        }
        public void checkEngine(){
            System.out.println("Двигатель в машине - " + engine);
        }

}




class Wheel{
        private int wheel;
        public Wheel(int wheel){
            this.wheel = wheel;
        }
        public void checkWheel(){

            System.out.println("У машины " + wheel +" колеса");

        }
}




class Car{
    private Engine _engine;
    private Wheel _wheel;
    private String mark;
    private int ChangeWheel;
    public Car(){
        _engine = new Engine("V8");
        _wheel = new Wheel(4);
        mark = "TOYOTA";
        ChangeWheel = 2;
    }
    public void checkMark(){
        System.out.println("Марка - " + mark);
    }
    public void refuel(){
        System.out.println("Машина заправлена");
    }

    public void changeWheel(){
        _wheel.checkWheel();
        System.out.println("У машины изменено " + ChangeWheel + " колес");
    }

    public void drive(){
        System.out.println("Машина может ехать");

    }
}
