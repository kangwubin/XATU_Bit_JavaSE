package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Description:接口：用来提供对书的操作。
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:23
 */
public interface IOperation {
    Scanner scanner = new Scanner(System.in);

    void work(BookList bookList);
}
