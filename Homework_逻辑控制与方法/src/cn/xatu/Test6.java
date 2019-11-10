package cn.xatu;

import java.util.Scanner;

//6. 求两个正整数的最大公约数
public class Test6 {
    public static int func2(int a,int b){
       if (a % b != 0){
          return a % b;
       }
       return a / b;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入要计算的数：");
        int num1=sc.nextInt();
        int num2=sc.nextInt();
        int  m,n,t;
        if (num1 > num2){
            m=num1;
            n=num2;
        }else {
            m=num2;
            n=num1;
        }while (m % n !=0){
            t = m%n;
            m = n;
            n = t;
        }
        System.out.print("最大公约数："+n);
    }
}
