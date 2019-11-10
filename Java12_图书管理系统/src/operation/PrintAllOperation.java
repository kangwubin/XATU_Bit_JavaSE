package operation;

import book.BookList;

public class PrintAllOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("打印所有书籍！");
        for (int i = 0; i < bookList.getSize(); i++) {
//            System.out.println(i);
            System.out.println(bookList.getBook(i));
        }
        System.out.println("共计" + bookList.getSize() + "本书！");
    }
}
