package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增一本书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名：");
        String name = scanner.next();
        System.out.println("请输入书的序号：");
        String id = scanner.next();
        System.out.println("请输入书的作者：");
        String author = scanner.next();
        System.out.println("请输入书的价格：");
        int price = scanner.nextInt();
        System.out.println("请输入书的类型：");
        String type = scanner.next();
        Book book = new Book(name,id,author,price,type,false);
        //插入到bookList中，尾插
        bookList.setBook(bookList.getSize(),book);
        bookList.setSize(bookList.getSize() + 1);
    }
}
