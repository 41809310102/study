package Operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddBook implements IBook{
    @Override
    public void work(BookList bookList) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入图书名字：");
        String name = sc.nextLine();
        System.out.print("请输入图书作者：");
        String acthor = sc.nextLine();
        System.out.print("请输入图书价格：");
          int  price = sc.nextInt();
        System.out.print("请输入图书类别：");
          String type = sc.next();
        Book book = new Book(name,acthor,price,type);
        int len = bookList.getUsedsize();
        bookList.setBooks(len,book);
        bookList.setUsedsize(len+1);
        System.out.println("添加成功！");
    }
}
