package Operation;

import book.BookList;

public class ExitBook implements IBook{
    @Override
    public void work(BookList bookList) {
       System.exit(-1);
    }
}
