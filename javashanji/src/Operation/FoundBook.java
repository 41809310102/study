package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class FoundBook implements IBook{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要查找图书的书名：");
        String name = scanner.nextLine();
        for (int i =0;i<bookList.getUsedsize();i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println("查找成功，有这本书！");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有这本书");
    }
}
