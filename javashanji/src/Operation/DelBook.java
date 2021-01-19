package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要删除的图书书名：");
        String name = scanner.nextLine();
        int i = 0;
        for (; i < bookList.getUsedsize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getUsedsize()) {
            System.out.println("没有要删除的书！");
            return;
                }

        int pos = i;
        for (int j = pos; j < bookList.getUsedsize() - 1; j++) {
            Book book = bookList.getBook(j + 1);
            bookList.setBooks(j, book);
                }
            bookList.setUsedsize(bookList.getUsedsize() - 1);
            System.out.println("删除成功！");
        }
    }