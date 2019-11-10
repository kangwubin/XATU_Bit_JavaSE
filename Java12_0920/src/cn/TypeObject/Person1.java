package cn.TypeObject;

public class Person1 {
    private String name;
    private int age;
    private String sex;
    private static int count=0; //静态成员变量

    //静态代码块不管生成多少个对象，其只会执行一次，且是最先执行的。
    //静态代码块执行完毕后, 实例代码块（构造块）执行，再然后是构造函数执行。
    public static void main(String[] args) {
        Person1 p1 = new Person1();
        Person1 p2 = new Person1();//静态代码块是否还会被执行？
    }

    //构造函数
    public Person1(){
        System.out.println("I am Person1  init()");
    }

    //实例化代码块
    {
        this.name="KWB";
        this.age=23;
        this.sex="男";
        System.out.println("I am instance  init()");
    }

    //静态代码块
    static {
        count=10;//只能访问静态数据成员
        System.out.println("I am static  init()");
    }

    public void show(){
        System.out.println("name: "+name+" age: "+age+" sex: "+sex);
    }

}

