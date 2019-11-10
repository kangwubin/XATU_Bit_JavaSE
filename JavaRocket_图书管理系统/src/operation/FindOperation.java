package operation;

import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:26
 */
public class FindOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        //1、输入查找图书的名字
        System.out.println("======查找书籍!======");
        System.out.println("请输入要查找的书名:");
        String name = scanner.next();
        //2、根据书籍的名称查找书籍是否存在   index
        int i = 0;
        for (; i < bookList.getUsedSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                System.out.println(bookList.getBook(i));
            }
        }
        if (i > bookList.getUsedSize()){
            System.out.println("对不起，没有此书！");
        }
        System.out.println("查找完毕！");
    }
}
