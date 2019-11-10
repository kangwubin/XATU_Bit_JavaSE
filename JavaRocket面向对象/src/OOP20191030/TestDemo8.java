package OOP20191030;

import java.util.Arrays;

/**
 * 自定义的类型如果进行克隆：
 * 1、implements Cloneable--->他是一个空接口
 * 面试问题：为什么Cloneable是一个空接口？？
 * 标记接口：作用-》标记当前类可以进行clone()
 * 2、重写一个方法:是  Object::clone()
 * 3、处理异常
 */
class Money implements Cloneable {
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable {
    public String name;
    public int age;

    Money m;    //使用组合

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.m = new Money();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person) super.clone();

        //this.m = (Money) p.m.clone();//可以
        p.m = (Money) this.m.clone();//可以
        return p;
        //return super.clone();
    }
}

public class TestDemo8 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("AAA", 18);
        Person person2 = (Person) person.clone();

        System.out.println(person.m.money);
        System.out.println(person2.m.money);

        person2.m.money = 99.9;
        System.out.println("通过person2改变money");
        System.out.println(person.m.money);
        System.out.println(person2.m.money);
    }

    public static void main2(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.name = "AAA";
        Person person2 = (Person) person.clone();
        person2.name = "BBB";
        System.out.println(person.name);
        System.out.println(person2.name);
    }

    public static void main1(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] array2 = array.clone();//Object
        System.out.println("array2 = " + Arrays.toString(array2));
    }
}
