package cn.xatu;

import java.util.Scanner;

//13. 输出一个整数的每一位
public class Test13 {
    public static void main(String[] args){
        System.out.println("请输入数字：");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        printNum(num);
    }
    public static void printNum(int n){
        if (n > 9){
            printNum(n / 10);
        }
        System.out.println("打印之后的数字："+n % 10);
    }
}
