package cn.xatu;
//8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9
public class Test8 {
    public static void main(String[] args){
        //1. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
        int count=0;
        for (int num=1;num<101;num++){
            if (num % 10==9){  //判断个位上是否有9
                count++;
            }
            if (num / 10==9){  //判断十位是否有9
                count++;
            }
        }
        System.out.print(count);
    }
}
