package cn.method;

import java.util.Scanner;

//图解：https://dmego.me/2016/10/16/hanoi.html
//实现代码: 求解汉诺塔问题(提示, 使用递归)
//汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。
//大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
//大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
//并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。
public class Test2_HanoiTower {
    //（1）把n-1个盘子由A 移到 B；
    //（2）把第n个盘子由 A移到 C；
    //（3）把n-1个盘子由B 移到 C；
    static int m =0;//标记移动次数
    public static void main(String[] args){
        Scanner imput = new Scanner(System.in);
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("*****************************************************************************");
        System.out.println("这是汉诺塔问题（把A塔上编号从小号到大号的圆盘从A塔通过B辅助塔移动到C塔上去）");
        System.out.println("*****************************************************************************");
        System.out.print("请输入圆盘的个数：");
        int disks = imput.nextInt();
        Test2_HanoiTower.HanoiTower(disks, A, B, C);
        System.out.println(">>移动了" + m + "次，把A上的圆盘都移动到了C上");
        imput.close();
    }
    //实现移动的函数
    public static void move(int disks,char N,char M){   //把1编号为n的圆盘从N移到M上
        System.out.println("第" + (++m) +" 次移动 : " +" 把 "+ disks+" 号圆盘从 " + N +" ->移到->  " + M);
    }
    //递归实现汉诺塔的函数
    public static void HanoiTower(int n,char A,char B,char C){   //把编号为n的圆盘借助B从A移动到 C上
        if (n==1){  //圆盘只有一个时，只需将其从A塔移到C塔
            Test2_HanoiTower.move(1,A,C);
        }else {
            HanoiTower(n-1,A,C,B);  //递归，把A塔上编号1~n-1的圆盘移到B上，以C为辅助塔
            Test2_HanoiTower.move(n,A,C);   //把A塔上编号为n的圆盘移到C上
            HanoiTower(n-1,B,A,C);  //递归，把B塔上编号1~n-1的圆盘移到C上，以A为辅助塔
        }
    }
}
