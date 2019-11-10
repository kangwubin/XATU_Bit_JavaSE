package cn.logiccontroller;

public class Test6_break {
    //break 的功能是让循环提前结束.
    public static void main(String[] args){
        //找到 100 - 200 中第一个 3 的倍数
        int num=100;
        while (num <= 200){
            num++;
            if (num % 3 == 0){
                System.out.println("找到了第一个3的倍数：num="+num);
                break;
            }
        }
    }
}
