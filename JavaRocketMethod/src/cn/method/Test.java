package cn.method;

public class Test {

    public static void main(String[] args) {
//        System.out.println(sum(10));
//        func(1234);
        System.out.println(sumNum(123));
        fib2(6);
    }

    //使用迭代版本实现斐波那契数列的第 N 项
    public static int fib2(int n){
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    //求斐波那契数列的第 N 项
    public static int fib(int n){
        if (n == 1 || n == 2){
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // 写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9=19
    public static int sumNum(int num){
        if (num < 10){
            return num;
        }
        return num % 10 + sumNum(num / 10);
    }

    //递归：按顺序打印一个数字的每一位(例如 1234 打印出 1 2 3  4
    public static void func(int num){
        if (num > 9){
            func(num / 10);
        }
        System.out.println(num % 10);
    }

    //递归求1+2+3....+10
    public static int sum(int n){
        if (n == 1){
            return 1;
        }
        return n + sum(n - 1);
    }

    //求1！+2！+3!....+n!
    public static void main1(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum = sum + factor(i);
        }
        System.out.println(sum);
    }

    //实现阶乘的函数
    public static int factor(int n){
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
