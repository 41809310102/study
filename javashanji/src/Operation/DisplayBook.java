package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DisplayBook implements IBook {
    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getUsedsize(); i++) {
            Book book = bookList.getBook(i);
            System.out.println(book);
        }
        System.out.println("以上是全部图书");
    }
}
