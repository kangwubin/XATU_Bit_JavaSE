package operation;

import book.Book;
import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:24
 */
public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======新增一本图书！======");
        System.out.println("请输入图书的名字：");
        String name = scanner.next();
        System.out.println("请输入图书的作者：");
        String author = scanner.next();
        System.out.println("请输入图书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入图书的类型：");
        String type = scanner.next();
        //根据你所输入的书籍信息-》构成一本书的对象
        Book book = new Book(name, author, price, type);
        //插入到bookList当中   尾插法
        int size = bookList.getUsedSize();
        bookList.setBook(size, book);
        bookList.setUsedSize(size + 1);
    }
}
