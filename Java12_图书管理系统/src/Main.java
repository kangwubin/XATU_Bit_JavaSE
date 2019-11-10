import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1.准备好书籍信息数据
        BookList bookList = new BookList();
        //2.创建用户（多态）
        User user = login();
        //3.进入主循环
        while (true){
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }

    private static User login() {
        System.out.println("请输入您的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入您的角色：（1.普通用户 2.管理员）");
        int role = scanner.nextInt();
        if (role == 1){
            return new NormalUser(name);
        }
        return new Admin(name);
    }
}
