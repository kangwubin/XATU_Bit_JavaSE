package cn.recursion;

public class Test6_Fib_For {
    //可以使用循环的方式来求斐波那契数列问题, 避免出现冗余运算.
    //斐波那契---1  1  2  3  5  8
    public static void main(String[] args) {
        int result=fib(6);
        System.out.println(result);
    }
    //fib函数
    public static int fib(int n){
        int last2=1;
        int last1=1;
        int cur=0;
        for (int i = 3; i <= n; i++) {
            cur = last1 + last2;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }
}
