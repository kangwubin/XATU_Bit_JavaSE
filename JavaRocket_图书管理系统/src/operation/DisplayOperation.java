package operation;

import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:26
 */
public class DisplayOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======显示所有图书！======");
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
