package cn.xatu;

import java.util.Random;
import java.util.Scanner;

//14. 完成猜数字游戏
public class Test14 {
    public static void main(String[] args){
        System.out.println("************--------************");
        System.out.println("************猜数字游戏************");
        System.out.println("************--------************");
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        int toGuess=random.nextInt(100);
        while (true){
            System.out.println("请输入数字：");
            int input=sc.nextInt();
            if (input < toGuess){
                System.out.println("您猜的小了！");
            }else if (input > toGuess){
                System.out.println("您猜的大了！");
            }else {
                System.out.println("您猜对了！");
                break;
            }
        }
        sc.close();
    }
}
