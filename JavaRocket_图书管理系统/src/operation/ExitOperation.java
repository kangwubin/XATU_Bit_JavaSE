package operation;

import book.BookList;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:26
 */
public class ExitOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("======您已退出系统！======");
        //结束程序：System.exit(0)=> C语言中的main函数return 0 ；0表示进程退出码，非0失败;
        System.exit(0);
    }
}
