package OOP20191030;

class Animal {
    public String name;
    public int age;

//    public Animal() {
//    }

    static {
        System.out.println("Animal::static{}");
    }

    {
        System.out.println("Animal::instance{}");
    }

    public Animal(String name, int age) {
        eat();  //构造方法内部可以发生多态
        this.name = name;
        this.age = age;
    }

    public void eat() {
        System.out.println("Animal: eat()");
    }

    public void sleep() {
        System.out.println("Animal: sleep()");
    }

}

class Cat extends Animal {
    public String sex;

    static {
        System.out.println("cat::static{}");
    }

    {
        System.out.println("cat::instance{}");
    }

    public Cat(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    @Override
    public void eat() {
        System.out.println("Cat :: eat()");
    }

    public void run() {
        System.out.println("Cat :: run()");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    public void fly() {
        System.out.println("Bird :: fly()");
    }
}

public class TestDemo1 {
    public static void main(String[] args) {
        Animal animal = new Bird("小鸟", 19);
        //向下转型->一定要发生向上转型->instanceof:
        if (animal instanceof Cat) {    //cat是否是animal的实例
            Cat cat = (Cat) animal;     //java.lang.ClassCastException---类型转换异常
            cat.run();
        }
    }

    //向下转型
    public static void main3(String[] args) {
        //向上转型
        Animal animal = new Cat("caocao", 19, "man");
        //向下转型
        Cat cat = (Cat) animal;
        cat.run();
    }

    //向上转型
    public static void main2(String[] args) {
        Animal animal = new Cat("大花猫", 19, "man");//父类引用子类对象
        animal.eat();
    }

    public static void main1(String[] args) {
        Cat cat = new Cat("caocao", 19, "man");
        System.out.println("==========================");
        Cat cat1 = new Cat("caocao", 19, "man");
    }
}
