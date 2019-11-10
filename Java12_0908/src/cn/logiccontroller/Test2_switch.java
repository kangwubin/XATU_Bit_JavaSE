package cn.logiccontroller;

public class Test2_switch {
    //switch(整数|枚举|字符|字符串)
    //根据 switch 中值的不同, 会执行对应的 case 语句. 遇到 break 就会结束该 case 语句.
    //如果 switch 中的值没有匹配的 case, 就会执行 default 中的语句.
    //我们建议一个 switch 语句最好都要带上 default
    public static void main(String[] args){
        int day = 6;
        switch(day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }
}
