package day25_200108;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2020/1/9
 * @Time: 16:34
 */
public class Main1 {
    /*北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。
     * 公式如下：
     * 实际成绩 ：90——100    85——89    82——84   78——81  75——77  72——74  68——71  64——67  60——63  60以下
     * 绩点：      4.0       3.7        3.3     3.0     2.7     2.3      2.0     1.5    1.0      0
     * 1．一门课程的学分绩点=该课绩点*该课学分
     * 2．总评绩点=所有学科绩点之和/所有课程学分之和
     * 现要求你编写程序求出某人A的总评绩点（GPA）。
     * 输入：第一行：总的课程数n（n<10）；第二行：相应课程的学分（两个学分间用空格隔开）；第三行：对应课程的实际得分；此处输入的所有数字均为整数。
     * 输出：输出有一行，总评绩点，精确到小数点后2位小数。*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int gradePoint[] = new int[n];//每门课学分
        int courseScore[] = new int[n];//每门课分数

        for (int i = 0; i < n; i++) {
            gradePoint[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            courseScore[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.printf("%.2f", gradePointAverage(gradePoint, courseScore));//格式输出

    }

    public static double pointOfEachCourse(int grade) {//根据实际成绩判断学分方法
        double point = 0.0;
        if (grade >= 90 && grade <= 100) {
            point = 4.0;
        }
        if (grade >= 85 && grade <= 89) {
            point = 3.7;
        }
        if (grade >= 82 && grade <= 84) {
            point = 3.3;
        }
        if (grade >= 78 && grade <= 81) {
            point = 3.0;
        }
        if (grade >= 75 && grade <= 77) {
            point = 2.7;
        }
        if (grade >= 72 && grade <= 74) {
            point = 2.3;
        }
        if (grade >= 68 && grade <= 71) {
            point = 2.0;
        }
        if (grade >= 64 && grade <= 67) {
            point = 1.5;
        }
        if (grade >= 60 && grade <= 63) {
            point = 1.0;
        }
        if (grade < 60) {
            point = 0.0;
        }
        return point;
    }

    //计算平均绩点的方法
    public static double gradePointAverage(int[] gradePoint, int[] coursePoint) {
        double gradePointTotal = 0;
        double gradeOfEachCourseTotal = 0;
        for (int i = 0; i < gradePoint.length; i++) {
            gradePointTotal += pointOfEachCourse(coursePoint[i]) * gradePoint[i];
            gradeOfEachCourseTotal += gradePoint[i];
        }
        return gradePointTotal / gradeOfEachCourseTotal;
    }
}
