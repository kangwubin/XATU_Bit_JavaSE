package cn.Constructor;

public class PersonTest {
    public static void main(String[] args) {
        Person person0=new Person();
        System.out.println(person0);
        Person person1=new Person("KWB");
        System.out.println(person1);
        Person person2=new Person("KWB","男");
        System.out.println(person2);
        Person person3=new Person("KWB","男",23);
        System.out.println(person3);
    }
}
