package User;

import operation.*;

import java.util.Scanner;

/**
 * Description:多态：一个引用多种表现形式
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:26
 */
public class Admin extends User {
    public Admin(String name) {
        super(name);
        Operations = new IOperation[]{
                new ExitOperation(), new FindOperation(), new AddOperation(),
                new DelOperation(), new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=============");
        System.out.println("hello " + name);
        System.out.println("1.查找图书");
        System.out.println("2.增加书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.打印所有信息");
        System.out.println("0.退出");
        System.out.println("=============");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
