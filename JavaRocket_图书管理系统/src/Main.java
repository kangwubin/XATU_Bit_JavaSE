import book.BookList;
import User.Admin;
import User.NormalUser;
import User.User;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:12
 */
public class Main {
    public static void main(String[] args) {
        //1.准备好书籍信息
        BookList bookList = new BookList();
        //2.创建用户（多态）
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }

    private static User login() {
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入您的角色：（1.普通用户 2.管理员）");
        int role = scanner.nextInt();
        if (role == 1) {
            return new NormalUser(name);
        }
        return new Admin(name);
    }
}
