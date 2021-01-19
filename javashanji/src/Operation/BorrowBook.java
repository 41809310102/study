package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowBook implements IBook {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要查找图书的书名：");
        String name = scanner.nextLine();
        for (int i =0;i<bookList.getUsedsize();i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.isStatues()==true){
                    System.out.println("该图书已经借出，无法借阅！");
                    return;
                }else{
                    book.setStatues(true);
                    return;
                }
            }
        }
        System.out.println("没有这本书,无法借阅");
    }
}
