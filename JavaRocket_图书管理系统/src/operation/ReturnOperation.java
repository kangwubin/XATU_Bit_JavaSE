package operation;

import book.Book;
import book.BookList;

/**
 * Description:归还图书，首先遍历整个bookList,看有没有这本书，如果有此书，再看有没有被借出去
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:26
 */
public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======归还图书！======");
        System.out.println("请输入你要归还的书籍");
        String name = scanner.next();
        Book book = null;
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                book = bookList.getBook(i);
                break;
            }
        }
        if (i > bookList.getUsedSize()) {
            System.out.println("没有此书籍");
            return;
        }
        /**
         * 1、找到了这本书，但是这本书根本没有被借出去过
         * 2、找到了这本书，这本书确实已经被借出去了
         */
        if (book != null && !book.isBorrowed()) {
            System.out.println("您没有借阅此书！");
            return;
        }
        if (book != null && book.isBorrowed()) {
            book.setBorrowed(false);
        }
        System.out.println("还书完成！");
    }
}
