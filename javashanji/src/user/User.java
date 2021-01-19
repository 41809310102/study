package user;

import Operation.IBook;
import book.Book;
import book.BookList;

abstract public class User {
    protected String name;
    protected IBook[] operation;

    public User(String name) {
        this.name = name;
    }
    abstract public int  menu();
    public void doOperation(int choice, BookList bookList){
        operation[choice-1].work(bookList);
    }
}
