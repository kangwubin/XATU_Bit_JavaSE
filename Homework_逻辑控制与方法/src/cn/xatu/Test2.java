package cn.xatu;

import java.util.Scanner;

//2. 判定一个数字是否是素数
public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i < 100; i++) {
            if (isPrime(i) == true){
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if (num % i == 0){
               return false;
            }
        }
        return true;
    }
}
