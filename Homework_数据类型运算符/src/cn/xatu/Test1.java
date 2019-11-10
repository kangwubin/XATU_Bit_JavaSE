package cn.xatu;
/*
* 1. 写代码实现: 给定两个 int 变量, 交换变量的值.
* */
public class Test1 {
    public static void main(String[] args){
        int  num1=16;
        int  num2=18;
        int  num=0;
        num=num2;
        num2=num1;
        num1=num;
        System.out.print("num1="+num1+";num2="+num2);
    }
}
