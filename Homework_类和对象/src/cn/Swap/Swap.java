package cn.Swap;

public class Swap {
    private int num1;
    private int num2;

    public void transform(int num1, int num2){
        int tmp = num2;
        num2 = num1;
        num1 = tmp;
        System.out.println("交换后的值为：num = " + num1 + ",num2 = " + num2);
    }
}
