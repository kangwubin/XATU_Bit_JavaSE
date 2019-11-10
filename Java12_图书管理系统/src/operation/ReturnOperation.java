package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======归还书籍======");
        System.out.println("请输入归还的书籍的序号：");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (!book.getId().equals(id)){
                continue;
            }
            //执行具体的还书操作
            if (!book.isBorrowed()){
                System.out.println("这本书已经被归还了！");
                break;
            }
            book.setBorrowed(false);
        }
    }
}
