package operation;

import book.Book;
import book.BookList;

/**
 * Description:借书操作：首先需要遍历查找看有没有这本书，如果有，就可以借，借完之后将setBorrowed设置为已借出，
 * 如果有此书，并且此书已经被借出去，则也是无法借阅；如果没有这本书，就提示没有此书，无法借阅！
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:25
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
