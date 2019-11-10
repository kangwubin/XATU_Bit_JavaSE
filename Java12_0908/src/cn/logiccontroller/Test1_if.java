package cn.logiccontroller;

public class Test1_if {
    //判定闰年
    public static void main(String[] args){
        int year=2019;
        if (year % 100 == 0){
            //判定世纪年
            if (year % 400 ==0){
                System.out.println("是闰年");
            }else {
                System.out.println("不是闰年");
            }
        }else {
            //普通闰年
            if(year % 4 == 0){
                System.out.println("是闰年");
            }else {
                System.out.println("不是闰年");
            }
        }
    }
}
