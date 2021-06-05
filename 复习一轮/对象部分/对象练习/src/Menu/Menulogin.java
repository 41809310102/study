package Menu;

import java.util.Scanner;

public class Menulogin {
    public  static  int Menulogin(){
        System.out.println("*****备战选择*****");
        System.out.println("按1 ：选择皮肤");
        System.out.println("按2 ：选择铭文");
        System.out.println("按3 ：进入游戏");
        System.out.println("按4 ：查看英雄属性");
        System.out.println("*****************");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        switch (res){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            default:
                System.out.println("参数错误，尝试重新连接"); Menulogin();break;
        }
        return 0;
    }
}
