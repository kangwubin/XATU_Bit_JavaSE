package operation;

import book.Book;
import book.BookList;

/**
 * Description:查找书籍：通过遍历整个bookList，然后根据书名进行查找，如果有这本书，就拿到这本书的下标，
 * 如果找不到就表示没有这本书。
 *
 * @author: KangWuBin
 * @Date: 2019/11/3
 * @Time: 18:26
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        //1、输入查找图书的名字
        System.out.println("======查找书籍!======");
        System.out.println("请输入要查找的书名:");
        String name = scanner.next();
        //2、根据书籍的名称查找书籍是否存在   index
        int count = 0;
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                // 打印这本书的信息
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("没有找到这本书！");
            System.out.println("查找完毕！");
        } else {
            System.out.println("共计找到 " + count + " 本书!");
        }
    }
}
