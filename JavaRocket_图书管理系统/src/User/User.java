package User;

import book.BookList;
import operation.IOperation;

/**
 * Description:将user设置为抽象类
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:26
 */
public abstract class User {
    protected String name;
    //持有当前用户支持的操作对象
    protected IOperation[] Operations;

    //打印一个操作菜单. 不同的用户支持的操作不同, 对应的菜单也就不同
    public abstract int menu();

    public User(String name) {
        this.name = name;
    }

    // 根据用户输入的选项(menu返回结果)
    // 调用对应的操作对象
    public void doOperation(int choice, BookList bookList) {
        Operations[choice].work(bookList);
    }
}
