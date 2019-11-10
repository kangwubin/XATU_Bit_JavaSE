package User;

import book.BookList;
import operation.IOperation;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:26
 */
public abstract class User {
    protected String name;
    protected IOperation[] Operations;

    public abstract int menu();

    // 根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        Operations[choice].work(bookList);
    }
}
