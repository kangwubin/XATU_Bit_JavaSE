package cn.recursion;

import java.util.Scanner;

//代码示例4 求斐波那契数列的第 N 项 ：1 1  2  3  5  8  13  21  34
//优化方法：避免重复计算（空间换时间）
//动态规划：核心本质是“空间换空间”
public class Test4_fib {
    public static void main(String[] args){
        System.out.println("请输入数字：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        System.out.println("斐波那契数列的第"+num+"项为："+fib(num));
    }
    public static int fib(int n){
        if (n==1 || n==2){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
}
