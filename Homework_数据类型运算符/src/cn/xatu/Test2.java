package cn.xatu;
/*
* 2. 写代码实现: 给定三个 int 变量, 求其中的最大值和最小值.
* */
public class Test2 {
	public static void main(String[] args){
		int a = 10;
		int b = 20;
		int c = (a > b ? a : b);
		System.out.println(c);
	}
	
    public static void main1(String[] args){
        int num1=16;
        int num2=18;
        int num3=20;
        if(num1 < num2 && num2 < num3){
            System.out.print("最小数为："+num1+";最大数为："+num3);
        }else {
            System.out.print("没有合适的值！");
        }

    }
}

