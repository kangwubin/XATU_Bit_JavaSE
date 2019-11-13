package List20191112;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:比特科技有若干学生(学生对象放在一个List中)，每个学生有一个姓名、班级和考试成绩属性，
 * 某次考试结束后，每个学生都获得一个考试成绩，遍历list集合，并把学生对象的属性打印出来。
 *
 * @author: KangWuBin
 * @Date: 2019/11/12
 * @Time: 10:02
 */
//对自定义类型排序：实现Comparable接口，重写compareTo方法
class Student implements Comparable<Student> {
    private String name;
    private String classes;
    private double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.score - o.score);
//        return this.name.compareTo(name);
    }
}

public class BitStudent {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student("A", "101", 96);
        Student student2 = new Student("B", "101", 88);
        Student student3 = new Student("C", "101", 90);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("------排序--------");
        Collections.sort(studentList);//对集合实现排序
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
