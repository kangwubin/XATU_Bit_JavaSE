package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:23
 */
public interface IOperation {
    Scanner scanner = new Scanner(System.in);
    void work(BookList bookList);
}
