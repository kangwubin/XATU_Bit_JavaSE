package OOP20191030;

interface IFlying {
    void fly();
}

interface IRunning {
    void run();
}

interface ISwimming {
    void swim();
}

class Animal2 {
    protected String name;

    public Animal2(String name) {
        this.name = name;
    }
}

class Cat2 extends Animal2 implements IRunning {
    public Cat2(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("猫在跑");
    }
}

class Dog extends Animal2 implements IRunning, ISwimming {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("狗在跑");
    }

    @Override
    public void swim() {
        System.out.println("狗在游泳");
    }
}

//abstract class A implements IRunning {
//}
//
//class B extends A {
//}

public class TestDemo5 {
    public static void func1(IRunning running) {
        running.run();
    }

    public static void main(String[] args) {
        Cat2 cat = new Cat2("caocao");
        func1(cat);

        Dog dog = new Dog("小狗");
        func1(dog);
    }
}
