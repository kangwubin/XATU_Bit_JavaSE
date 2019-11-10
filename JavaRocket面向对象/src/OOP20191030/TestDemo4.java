package OOP20191030;

/*
 * 1.接口当中的方法一定不能有具体实现------->抽象方法
 * 2.void draw()-》默认 public abstract void draw();
 * 3.int a = 10-》默认 public static final int a = 10;
 * 4.普通的类不能继承接口，但是可以实现
 * 5.接口不可以实例化，但是可以发生向上转型
 * 6.一个类可以实现多个接口:
 * class Dog extends Animal2 implements IRunning,ISwimming
 * 7.抽象类可以实现接口
 * 8.接口和接口之间不能发生实现，
 * 但是他们之间可以继承,interface C extends B,A；A和B均为接口
 * */
interface IShape {
    int a = 10;

    void draw();
}

class Cycle2 implements IShape {
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}

class Rect2 implements IShape {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}

public interface TestDemo4 {
    public static void main(String[] args) {
        IShape shape = new Cycle2();
        IShape shape1 = new Rect2();
    }
}
