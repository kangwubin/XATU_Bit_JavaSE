package cn.recursion;
//写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入1729, 则应该返回1+7+2+9，它的和是19
public class Test3_sum {
    public static void main(String[] args){
        int result=sum(123);
        System.out.println(result);
    }
    public static int sum(int num){
        if ( num < 10){
            return num;
        }
        return num % 10 + sum(num / 10);
    }
}
