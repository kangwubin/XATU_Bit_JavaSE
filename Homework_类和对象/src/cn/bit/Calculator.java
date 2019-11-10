package cn.bit;

// 编写一个类Calculator,有两个属性num1,num2,这两个数据的值，不能在定义的同时初始化，最后实现加减乘除四种运算
public class Calculator {
    private double num1;
    private double num2;

    public Calculator() {
    }

    public Calculator(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                '}';
    }

    public double sum(double num1,double num2){
        return num1 + num2;
    }

    public double sub(double num1,double num2){
        return num1 - num2;
    }

    public double mul(double num1,double num2){
        return num1 * num2;
    }

    public double div(double num1,double num2){
        return num1 / num2;
    }

}
