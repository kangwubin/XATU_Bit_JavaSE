package OOP20191030;

/**
 * 0.抽象方法没有实现的方法    abstract
 * 1.抽象类是包含抽象方法的类    abstract
 * 2.抽象类可以包含抽象方法，也可以包含非抽象方法
 * 3.抽象类不可以被实例化  不能new
 * 4.一个普通的类，如果继承了抽象类，一定要重写抽象类的抽象方法
 * 5.抽象类A可以继承抽象类B，这样就不需要重写抽象方法
 * 6.如果一个普通类C继承了上述抽象类A，如果上述抽象类A并没有重写抽象类B的抽象方法，那么当前的普通类C一定要重写
 * 7.抽象方法一定不能是private；抽象类不能被final所修饰
 */
abstract class Shape1 {
    public abstract void draw();
}
/*abstract class A extends Shape1 {

}

class B extends A {

    @Override
    public void draw() {

    }
}*/

class Cycle1 extends Shape1 {

    @Override
    public void draw() {
        System.out.println("画圆");
    }
}

class Rect1 extends Shape1 {

    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}


public class TestDemo3 {
    public static void drawMap(Shape1 shape1) {
        shape1.draw();
    }

    public static void main(String[] args) {
        Shape1 shape1 = new Cycle1();
        Shape1 shape2 = new Rect1();
        drawMap(shape1);
        drawMap(shape2);
    }
}
