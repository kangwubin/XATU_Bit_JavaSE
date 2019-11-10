package book;

/**
 * Description:
 *
 * @author: KangWuBin
 * @Date: 2019/11/3 18:12
 */
public class BookList {
    private Book[] books = new Book[100];
    private int usedSize = 0;

    public Book getBook(int pos) {
        return this.books[pos];
    }

    public void setBook(int pos, Book book) {
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public BookList() {
        books[0] = new Book("Java编程思想", "AUT", 12, "学习");
        books[1] = new Book("Java核心卷一", "BUT", 15, "学习");
        books[2] = new Book("TCP/IP", "PTO", 21, "学习");
        this.usedSize = 3;
    }
}
