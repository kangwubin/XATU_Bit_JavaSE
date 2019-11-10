package operation;

import book.Book;
import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:25
 */
public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======借阅图书！======");
        //1、输入需要借阅书籍的名称
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        //2、根据书籍的名称查找书籍是否存在
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        //3、拿到书籍的对象 将书籍对象的isBorrowed = true
        if (i >= bookList.getUsedSize()) {
            System.out.println("没有找到此书");
            return;
        }
        //i为此时借阅的书籍的下标
        Book book = bookList.getBook(i);
        if (book.isBorrowed()) {
            System.out.println("此书已经被借出去！");
        } else {
            book.setBorrowed(true);
            System.out.println("借阅成功！");
        }
    }
}
