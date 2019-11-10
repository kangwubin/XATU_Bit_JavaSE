package cn.logiccontroller;

public class Test5_while {
    public static void main(String[] args){
        //计算 1! + 2! + 3! + 4! + 5!
        int num=1;
        int sum=0;
        //外层循环求和
        while (num <= 5){
            //里层循环求阶乘
            int result=1;
            int tmp=1;
            while (tmp <= num){
                result *= tmp;
                tmp++;
            }
            sum += result;
            num++;
        }
        System.out.println(sum);
    }
}
