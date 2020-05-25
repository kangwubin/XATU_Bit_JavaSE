package day19_200101;

import java.util.*;

/**
 * Description:
 * 输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩都按先录入排列在前的规则处理。
 * 输入：输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开；
 * 输出：按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开；
 *
 * @author: KangWuBin
 * @Date: 2020/1/1
 * @Time: 11:27
 */
class Student {
    public int index;
    public String name;
    public int score;

    public Student(int index, String name, int score) {
        this.index = index;
        this.name = name;
        this.score = score;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int numStudent = scanner.nextInt();
            int menu = scanner.nextInt();
            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < numStudent; i++) {
                studentList.add(new Student(i, scanner.next(), scanner.nextInt()));
            }
            //降序排序
            if (menu == 0) {
                Collections.sort(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.score != o2.score) {
                            //后面减去前面，如果相减为负，表示降序
                            return o2.score - o1.score;
                        } else {
                            //分数相等，按照序号的优先顺序保存
                            //前面减去后面，如果相减为负，表示升序
                            return o1.index - o2.index;
                        }
                    }
                });
            }
            if (menu == 1)//升序
            {
                Collections.sort(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        if (o1.score != o2.score) {
                            return o1.score - o2.score;
                        } else {
                            return o1.index - o2.index;
                        }
                    }
                });
            }
            for (Student stu : studentList) {
                System.out.println(stu.name + " " + stu.score);
            }
        }
    }
}
