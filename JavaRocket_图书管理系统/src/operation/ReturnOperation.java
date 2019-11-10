package operation;

import book.Book;
import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:26
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


    }
}
