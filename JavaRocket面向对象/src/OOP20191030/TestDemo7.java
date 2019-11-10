package OOP20191030;

import java.util.Arrays;

//对于自定义类型排序时：实现Comparable接口
class Student implements Comparable<Student> {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    private double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {   //o是传入的对象
//        return this.age - o.age;
//        return this.name.compareTo( o.name);    //compareTo--比较两个字符串的大小
        return (int) (this.score - o.score);
    }
}

public class TestDemo7 {
    public static void main2(String[] args) {
        int[] array = {10, 4, 1, 9, 8};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("A", 99, 99.8);
        students[1] = new Student("AA", 88, 88.6);
        students[2] = new Student("AAA", 68, 56.6);
        System.out.println(Arrays.toString(students));
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}
