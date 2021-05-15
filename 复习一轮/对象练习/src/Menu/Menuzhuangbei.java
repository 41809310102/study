package Menu;

import java.util.Scanner;

public class Menuzhuangbei {
    //装备页面
    public static  int Menuzhuangbei(){
        System.out.println("++++++++++++++++++++++");
        System.out.println("1.抵抗之靴");
        System.out.println("2.反甲");
        System.out.println("3.暗影战斧");
        System.out.println("4.极寒风暴");
        System.out.println("5.破军");
        System.out.println("6.碎星锤");
        System.out.println("7.魔女斗篷");
        System.out.println("10.进入技能页面");
        System.out.println("11.进入刷怪页面");
        System.out.println("++++++++++++++++++++++");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        switch (res){
            case 1: return 1;
            case 2: return 2;
            case 3: return 3;
            case 4: return 4;
            case 5: return 5;
            case 6: return 6;
            case 7: return 7;
            case 10:return 10;
            case 11:return 11;
            default:return 12;
        }
    }

}
