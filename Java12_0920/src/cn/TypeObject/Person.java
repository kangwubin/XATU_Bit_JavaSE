package cn.TypeObject;

public class Person {

    //类的属性/字段/成员变量
    public String name;
    public String sex;
    public int age;

    //默认构造函数
    public Person() {
        this.name="曹操";
        this.sex="男";
        this.age=18;
    }

    //带有三个参数的构造函数
    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void show(){
        System.out.println("name="+name+",sex="+sex+",age="+age);
    }

    //类的方法
    public void eat(){
        System.out.println(name+"在吃饭");
    }
    public void sleep(){
        System.out.println(name+"在睡觉");
    }
}
