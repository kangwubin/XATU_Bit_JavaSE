package user;

import book.BookList;
import operation.IOperation;

import java.util.Scanner;

abstract public class User {
    protected String name;
    Scanner scanner = new Scanner(System.in);
    // 持有当前用户支持的操作对象
    protected IOperation[] operations;
    // 打印一个操作菜单. 不同的用户支持的操作不同, 对应的菜单也就不同
    abstract public int menu();

    public User(String name) {
        this.name = name;
    }
    // 根据用户输入的选项(menu返回结果)
    // 调用对应的操作对象
    public void doOperation(int choice, BookList bookList){
        operations[choice].work(bookList);
    }
}
