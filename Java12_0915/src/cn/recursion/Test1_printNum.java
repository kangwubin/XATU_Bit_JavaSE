package cn.recursion;

import java.util.Scanner;
//代码示例1 按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3 4)
public class Test1_printNum {
    public static void main(String[] args){
        System.out.println("请输入数字：");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        printNum(num);
    }
    public static void printNum(int num){
        if (num > 9){
            printNum(num / 10);
        }
        System.out.println("打印之后的数字："+num % 10);
    }
}
