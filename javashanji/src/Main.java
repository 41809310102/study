import book.BookList;
import user.User;
import user.AdminUser;
import user.NormalUser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true){
           int choice = user.menu();
           user.doOperation(choice,bookList);
        }

    }

    public static User login(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name =sc.nextLine();
        System.out.println("请输入身份 1--》管理员登录   2--》普通用户登录");
        int  choice = sc.nextInt();
        if (choice == 1){
            return new AdminUser(name);
        }else{
            return new NormalUser(name);
        }
    }
}
