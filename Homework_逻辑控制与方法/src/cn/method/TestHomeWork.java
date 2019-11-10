package cn.method;

import java.util.Scanner;

public class TestHomeWork {
    //1.根据年龄, 来打印出当前年龄的人是少年(低于18),青年(19-28), 中年(29-55), 老年(56以上)
    public static void func1(int age) {
        if (age <= 18) {
            System.out.println("少年");
        } else if (age >= 19 && age <= 28) {
            System.out.println("青年");
        } else if (age >= 29 && age <= 55) {
            System.out.println("中年");
        } else {
            System.out.println("老年");
        }
    }

    //2.判定一个数字是否是素数 n  1  n   2-n-1
    //3.打印 1 - 100 之间所有的素数
    public static boolean isPrime1(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime2(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
            //return true;
        }
        return true;
    }

    //最优解
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //4.输出 1000 - 2000 之间所有的闰年
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    //5. 输出乘法口诀表
    public static void mutiTable(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + " ");
            }
            System.out.println();
        }
    }

    //6.求两个正整数的最大公约数(使用辗转相除法)
    public static int func2(int a, int b) {
        int c = 0;  // 余数
        while (a % b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return c;
    }

    //7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
    public static double sumN(int n) {
        double sum = 0.0;
        int flg = 1;
        for (int i = 1; i <= 100; i++) {
            sum += flg * 1.0 / i;
            flg = -flg;   //难在这里
        }
        return sum;
    }

    //8.编写程序数一下 1到 n 的所有整数中出现多少个数字9。
    public static int numOfNine(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i % 10 == 9) {
                count++;
            }
            if (i / 10 == 9) {
                count++;
            }
        }
        return count;
    }

    //9.求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
    //身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
    // 132/10=12    12/10=1   1/10=0
    public static void waterFlower(int n) {
        for (int i = 0; i <= n; i++) {
            int sum = 0;    //保存每一位数字的次方和
            int count = 0;  //记录当前数字的位数
            int tmp = i;
            //求i是几位数
            while (tmp != 0) {
                count++;
                tmp = tmp / 10;
            }
            tmp = i;
            //求tmp的每一位上的数字   123
            while (tmp != 0) {
                //Math.pow(a,b),a的b次方
                sum = sum + (int)Math.pow(tmp % 10,count);
                tmp = tmp / 10;
            }
            if (sum == i){
                System.out.println(i);
            }
        }
    }

    //10.编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
    //入，最多输入三次。三次均错，则提示退出程序
    public static void guess() {
        int count = 3;
        while (count != 0) {
            String OkPassword = "KWB19961128";
            System.out.print("请输入密码：");
            Scanner sc = new Scanner(System.in);
            String password = sc.nextLine();
            if (password.equals(OkPassword)) {
                System.out.print("登录成功，您输入的密码是：" + password);
                break;
            } else {
                count--;
                System.out.print("剩余的机会次数：" + count + "\n");
            }
        }
    }

    //11.写一个函数返回参数二进制中 1 的个数 比如： 15=>0000 1111->4个1---(重点)
    //  0000 1111   ---4个1
    //  123         123%10=3
    //  123/10=12   12%10=2
    //  12/10=1     1%10=1
    public static int numberOfOne1(int num) {
        int count = 0;  //计数1出现的个数
        while (num != 0) {
            if (num % 2 == 1) {
                count++;
            }
            num = num / 2;
        }
        count++;
        return count;
    }
    //最优解
    public static int numberOfOne(int num) {
        int count = 0;  //记录1出现的次数
        while(num != 0) {
            count++;
            num = num & (num-1);
        }
        return count;
    }

    //12.获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
     public static void func3(int num){
         for (int i = 31; i >= 1 ; i-=2) {
             System.out.println((num >> i) & 1);
         }
         for (int i = 30; i >= 0 ; i-=2) {
             System.out.println((num >> i) & 1);
         }
     }
    //13.输出一个整数的每一位.
    public static void printEveryNum(int num){
        if (num > 9){
            printEveryNum(num / 10);
        }
        System.out.println(num % 10);
    }
    //14. 完成猜数字游戏

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        func1(age);
        //3.打印 1 - 100 之间所有的素数
        for (int i = 1;i <= 100;i++){
            if (isPrime1(i)){
                System.out.println(i);
            }
        }
        //4.输出 1000 - 2000 之间所有的闰年
        for (int i = 1000 ; i < 2000; i++) {
            if(isLeapYear(i) == true){
                System.out.println(i);
            }
        }
        //测试最大公约数
        int ret = func2(18,24);
        System.out.println(ret);
        //测试乘法口诀
        mutiTable(9);
        //测试计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double ret1 = sumN(n);
        System.out.println(ret1);
        //测试编写程序数一下 1到 100 的所有整数中出现多少个数字9。
        int ret2 = numOfNine(n);
        System.out.println(ret2);
        //
        guess();
        int ret3 = numberOfOne(n);
        System.out.println(ret3);
        //13
        printEveryNum(n);
    }
}
