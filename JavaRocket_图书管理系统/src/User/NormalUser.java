package User;

import operation.*;

import java.util.Scanner;

/**
 * Description:多态的体现
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:27
 */
public class NormalUser extends User {
    public NormalUser(String name) {
        super(name);
        //构造operation数组
        //数组中 operation 对象的顺序和菜单中的序号相匹配
        Operations = new IOperation[]{
                new ExitOperation(), new FindOperation(),
                new BorrowOperation(), new ReturnOperation()
        };
    }


    @Override
    public int menu() {
        System.out.println("============");
        System.out.println("hello " + name);
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出");
        System.out.println("=============");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
//        scanner.close();  //close本质上是关闭system.in
        return choice;
    }
}
