package cn.logiccontroller;

public class Test7_continue {
    //continue 的功能是跳过这次循环, 立即进入下次循环.
    //代码示例: 找到 100 - 200 中所有 3 的倍数
    public static void main(String[] args){
        int num=100;
        while (num <= 200){
            if (num % 3 != 0){
                num++;
                continue;
            }
            num++;
            System.out.println("找到了3的倍数：num="+num);
        }
    }
}
