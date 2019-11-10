package cn.recursion;

import java.util.Scanner;

//代码示例2 递归求 1 + 2 + 3 + ... + 10
//递归结束条件；递归规则(sum(10)=>10+sum(9))
public class Test2_sum {
    public static void main(String[] args){
        System.out.println("请输入数字：");
        Scanner input=new Scanner(System.in);
        int num=input.nextInt();
        sum(num);
        System.out.print("1+2+3+...+"+num+"的和为："+sum(10));
    }
    public static int sum(int num){
        if (num == 1){
            return 1;
        }
        return num+sum(num-1);
    }
}
