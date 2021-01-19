package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class ReturnBook implements  IBook {
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入需要归还的图书的书名：");
        String name = scanner.nextLine();
        for (int i =0;i<bookList.getUsedsize();i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                if(book.isStatues()==false){
                    System.out.println("该图书没有被借出，请重新输入！");
                    return;
                }else{
                    book.setStatues(false);
                    System.out.println("归还成功！");
                    return;
                }
            }
        }
        System.out.println("没有这本书,无法归还");
    }
}

