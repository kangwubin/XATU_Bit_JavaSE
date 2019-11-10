package OOP20191030;

interface A {

}

interface B {
    void fun1();
}

interface C extends B,A {
    void fun2();
}

class D implements C {
    @Override
    public void fun1() {

    }

    @Override
    public void fun2() {

    }
}

public class TestDemo6 {
}
