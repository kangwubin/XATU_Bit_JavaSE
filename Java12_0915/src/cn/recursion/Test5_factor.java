package cn.recursion;
//递归求 N 的阶乘
public class Test5_factor {
    public static void main(String[] args){
        int n=5;
        int result=factor(n);
        System.out.println(result);
    }
    public static int factor(int n){
        System.out.println("函数开始：n="+n);
        if (n==1){
            return 1;
        }
        int result=n * factor(n-1);
        System.out.println("函数结束: n = " + n + " result = " + result);
        return result;
    }
}
