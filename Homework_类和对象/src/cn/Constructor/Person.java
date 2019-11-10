package cn.Constructor;

public class Person {
    private String name;
    private String sex;
    private int age;

    public Person() {
        System.out.println("这是空构造函数！");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("这是一个参数的构造函数");
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
        System.out.println("这是两个参数的构造函数！");
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        System.out.println("这是三个参数的构造函数！");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
