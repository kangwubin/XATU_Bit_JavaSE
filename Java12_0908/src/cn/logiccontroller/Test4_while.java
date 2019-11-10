package cn.logiccontroller;

public class Test4_while {
    public static void main(String[] args){
        //计算 5 的阶乘
        int n=1;
        int result=1;
        while (n<=5){
            result *= n;
            n++;
        }
        System.out.println(result);
    }
}
