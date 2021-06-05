package skin;

import yeguai.*;
import zhuangbei.Fajia;

import java.util.Scanner;

public class Yaseisskin {

    public  static  int Yaseisskin(){
        System.out.println("_________________________");
        System.out.println("    1. 亚瑟-圣骑之力       ");
        System.out.println("    2. 亚瑟-死亡骑士       ");
        System.out.println("    3. 亚瑟-狮心王         ");
        System.out.println("    4. 亚瑟-心灵战警       ");
        System.out.println("_________________________");
        Scanner sc = new Scanner(System.in);
        int res = sc.nextInt();
        if(res==1){
           int add = Yuanshenskin();
           return add;
        }
        if(res==2){
            int add = Firstskin();
            return add;
        }
        if(res==3){
            int add = Secondskin();
            return add;
        }
        if(res==4){
            int add = Thirdskin();
            return add;
        }
        return 0;
    }



    private static int Yuanshenskin(){
        System.out.println("亚瑟穿上了“亚瑟-圣骑之力”皮肤");
        int phyattack =0;
        return phyattack;
    }

    private static int Firstskin(){
        System.out.println("亚瑟穿上了“亚瑟-死亡骑士”皮肤");
        int phyattack =20;
        return phyattack;
    }

    private  static  int Secondskin(){
        System.out.println("亚瑟穿上了“亚瑟-狮心王 ”皮肤");
        int phyattack =20;
        return phyattack;
    }

    private  static  int Thirdskin(){
        System.out.println("亚瑟穿上了“亚瑟-心灵战警 ”皮肤");
        int phyattack =20;
        return phyattack;
    }
}
