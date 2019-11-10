package operation;

import book.Book;
import book.BookList;

/**
 * Description:管理员删除书籍，首先查找有没有这本书，如果有此书，就删除，如果没有此书，就不用删除。
 * 删除的操作：拿到i+1下标的对象，把i+1下标的对象赋值给i
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:25
 */
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======删除图书！======");
        //1、输入删除图书的名字
        System.out.println("输入删除图书的名字");
        String name = scanner.next();
        //2、根据书籍的名称查找书籍是否存在   index
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getUsedSize()) {
            System.out.println("没有删除的书籍");
            return;
        }
        //3、删除的逻辑  i = i+1    对象
        //   1、拿到i+1下标的对象
        //   2、把i+1下标的对象赋值给i
        for (int j = i; j < bookList.getUsedSize() - 1; j++) {
            Book book = bookList.getBook(j + 1);
            bookList.setBook(j, book);
        }
        bookList.setUsedSize(bookList.getUsedSize() - 1);
    }
}
