package cn.xatu;

import java.util.Scanner;

//10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,
// 密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
public class Test10 {
    public static void main(String[] args) {
        int count = 3;
        while (count != 0){
            String OkPassword = "KWB19961128";
            System.out.print("请输入密码：");
            Scanner sc = new Scanner(System.in);
            String password = sc.nextLine();
            if (password.equals(OkPassword)){
                System.out.print("登录成功，您输入的密码是：" + password);
                break;
            }else {
                count--;
                System.out.print("剩余的机会次数："+count+"\n");
            }
        }
    }
}
