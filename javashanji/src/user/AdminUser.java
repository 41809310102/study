package user;

import Operation.*;

import java.util.Scanner;

public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
        this.operation = new IBook[]{
                new FoundBook(),
                new AddBook(),
                new DelBook(),
                new DisplayBook(),
                new ExitBook()
        };
    }

    @Override
    public int menu() {
        System.out.println("==========================");
        System.out.println("欢迎"+name+"使用图书管理系统");
        System.out.println("      1.查找图书     ");
        System.out.println("      2.新增图书     ");
        System.out.println("      3.删除图书     ");
        System.out.println("      4.显示所有图书  ");
        System.out.println("      5.退出系统     ");
        System.out.println("===========================");
        System.out.println("请输入你的选择：");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

}
