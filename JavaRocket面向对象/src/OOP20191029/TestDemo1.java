package OOP20191029;

class Animal {
    protected String name;
    protected String sex;

    public Animal(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public void eat(String food) {
        System.out.println(this.name + "正在吃" + food);
    }
}
class Cat extends Animal{
    private int age;
    public Cat(String name, String sex,int age) {
        //调用父类的构造方法====构造方法没有被继承，是被调用的
        super(name, sex);
        this.age = age;
    }
}

public class TestDemo1 {

}
