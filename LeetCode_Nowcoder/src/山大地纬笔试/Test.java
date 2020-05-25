package 山大地纬笔试;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/3/17
 * @Time: 21:18
 */
class Student {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Test {
    public static void main(String[] args) {
        Student stu1 = new Student("zhangsan", 23);
        Student stu2 = stu1;
        refChg(stu2);
        System.out.println(stu1.name + "" + stu1.age);
    }

    private static void refChg(Student stu) {
        stu.name = "wangwu";
        stu.age = 10;
    }
}
