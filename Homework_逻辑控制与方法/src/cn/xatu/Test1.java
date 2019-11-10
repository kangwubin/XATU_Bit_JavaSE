package cn.xatu;

import java.util.Scanner;

//1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
public class Test1 {
public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("请输入年龄：");
    int age = sc.nextInt();
    if (age < 0){
        System.out.print("输入的年龄不有误，请正确输入！");
    }else if(age > 0 && age <= 18){
        System.out.print("当前年龄的人是少年!");
    }else if(age >= 19 && age <= 28){
        System.out.print("当前年龄的人是青年!");
    }else if(age >= 29 && age <= 55){
        System.out.print("当前年龄的人是中年!");
    }else {
        System.out.print("当前年龄的人是老年!");
    }
  }
}
