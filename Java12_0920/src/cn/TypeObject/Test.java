package cn.TypeObject;

public class Test {
    public static void main(String[] args) {
        //调用不带参数的构造函数 如果程序没有提供会调用不带参数的构造函数
        Person person1=new Person();
        person1.show();
        person1.eat();
        person1.sleep();
        //调用带有3个参数的构造函数
        Person person2=new Person("张飞","男",20);
        person2.show();
        person2.eat();
        person2.sleep();
        System.out.println();
    }
}
