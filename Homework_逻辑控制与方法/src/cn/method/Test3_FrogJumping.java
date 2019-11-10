package cn.method;
//实现代码: 青蛙跳台阶问题(提示, 使用递归)
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n 级的台阶总共有多少种跳法
public class Test3_FrogJumping {
    public static void main(String[] args){
        int result=FrogJump(4);
        System.out.println(result);
    }
    public static int FrogJump(int n){
        if (n <= 0){
            return 0;
        }if (n == 1){
            return 1;
        }if (n == 2){
            return 2;
        }
        return FrogJump(n-1)+ FrogJump(n-2);
    }
}
