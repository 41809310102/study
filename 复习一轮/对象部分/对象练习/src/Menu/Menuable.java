package Menu;

import java.util.Scanner;

public class Menuable {
    //技能菜单
    public  static  int Menuable(){
        System.out.println("***************");
        System.out.println("按1 ：技能一（控制）");
        System.out.println("按2 ：技能二（伤害）");
        System.out.println("按3 ：技能三（控制）");
        System.out.println("按0 ：自动平A");
        System.out.println("按10 ：攻击野怪");
        System.out.println("按11 ：购买装备");
        System.out.println("***************");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        switch (res){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 0: return 0;
            case 10: return 10;
            case 11: return 11;
            default:return 4;
        }
    }
}
