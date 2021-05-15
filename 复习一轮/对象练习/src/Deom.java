import Hero.Hero;
import Menu.Menuable;
import Menu.Menulogin;
import Menu.Menuyeguai;
import Menu.Menuzhuangbei;
import skin.Yaseisskin;
import yeguai.*;
import zhuangbei.Anyinzhanfu;
import zhuangbei.Fajia;
import zhuangbei.Shoe;

import java.util.Scanner;

public class Deom {
    public static void main(String[] args) {
         Hero yase = new Hero("亚瑟","战士",1000,200,0,500,200,50,0);
        System.out.println(yase.getName()+"当前属性为"+" 金币 "+yase.getMoney()+" 物理攻击 "+yase.getPhyattack()+" 血量 "+yase.getBlood()+" 移速 "+yase.getMove()
                );
        Menulogin menulogin =new Menulogin();
        if(menulogin.Menulogin()==1){
          int num = Yaseisskin.Yaseisskin();
          yase.setPhyattack(yase.getPhyattack()+num);
            System.out.println("皮肤穿戴成功！");
            System.out.println(yase.getName()+"当前属性为"+" 金币 "+yase.getMoney()+" 物理攻击 "+yase.getPhyattack()+" 血量 "+yase.getBlood()+" 移速 "+yase.getMove()
            );
        }
        int flag=menulogin.Menulogin(); //游戏开始标记符；
        System.out.println("欢迎来到王者荣耀，敌方还有3秒进入战场！全军出击！");
        Boolean red = false;
        Boolean blue = false; //默认英雄初始是没有buff的
        while (flag==3) {
            Menuable menuable = new Menuable();
            Menuyeguai menuyeguai = new Menuyeguai();
            Menuzhuangbei menuzhuangbei = new Menuzhuangbei();
            int res = menuable.Menuable(); //技能菜单
            int[] arr = new int[4];
            switch (res) {   //技能生效操作
                case 1:
                    System.out.println("当前使用一技能誓约之盾！");
                    arr = Firstable(red);
                    System.out.println("buff状态："+"红buff:"+red+" 蓝buff:"+blue);
                    break;
                case 2:
                    System.out.println("当前使用二技能回旋打击！");
                    arr = Secondable(red, blue);
                    System.out.println("buff状态："+"红buff:"+red+" 蓝buff:"+blue);
                    break;
                case 3:
                    System.out.println("当前使用三技能圣剑裁决！");
                    arr = Thirdable(red, blue);
                    System.out.println("buff状态："+"红buff:"+red+" 蓝buff:"+blue);
                    break;
                case 10:
                    int res1 = menuyeguai.Menuyeguai();
                    switch (res1){  //刷野生效操作
                        case 80:
                        case 100:
                        case 150:
                        case 200:
                        case 250:yase.setMoney(yase.getMoney()+res1);break;
                        case 1: red = true;break;
                        case 0: blue = true;break;
                        case 10:;
                        case 11:;
                        default:
                            System.out.println("系统错误");
                    }
                    break;
                case 11:
                    int res2 = menuzhuangbei.Menuzhuangbei();
                    switch (res2){  //进入装备购买页面
                        case 1:
                            Shoe shoe = new Shoe();
                            if(yase.getMoney()>=200){
                            System.out.println(yase.name+"购买了"+shoe.name);
                            yase.phyfangyu+=shoe.getPhyattack();
                            yase.move+=shoe.getMove();
                            yase.money=yase.money-200;
                        }else{
                                System.out.println("金币不足，无法购买"+shoe.name);
                            };break;
                        case 2:
                            Fajia fajia = new Fajia();
                            if(yase.getMoney()>=1200){
                            System.out.println(yase.name+"购买了"+fajia.name);
                            yase.phyattack+=fajia.getPhyattack(); //攻击力+
                            yase.phyfangyu+=fajia.getPhyfanyu();  //防御力+
                            yase.money=yase.money-1200;
                        }else {
                                System.out.println("金币不足，无法购买"+fajia.name);
                            };break;
                        case 3:
                            Anyinzhanfu anyinzhanfu = new Anyinzhanfu();
                            if(yase.getMoney()>=2000){
                            System.out.println(yase.name+"购买了"+anyinzhanfu.name);
                            yase.phyattack+=anyinzhanfu.getPhyattack(); //攻击力+
                            yase.blood+=anyinzhanfu.getBlood();  //生命力+
                            yase.money=yase.money-2000;
                        }else {
                                System.out.println("金币不足，无法购买"+anyinzhanfu.name);
                            }
                            break;
                        case 10:
                        case 11:
                        default:
                            System.out.println("系统错误");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("自动平A中。。。。");
                    break;
            }
            yase.setPhyattack(yase.getPhyattack()+arr[0]);
            yase.setBlood(yase.getBlood()+arr[1]);
            yase.setMove(yase.getMove()+arr[2]);
            System.out.println(yase.getName()+"当前属性为"+" 金币 "+yase.getMoney()+" 物理攻击 "+yase.getPhyattack()+" 血量 "+yase.getBlood()+" 移速 "+yase.getMove()
            +" 当前技能冷却时间 "+arr[3]+"ms");


        }

    }

    //亚瑟的一技能
    public static  int[] Firstable(boolean Redbuff){  //给技能一个参数，如果有红buff或蓝buff,那么技能属性就会提升
        int[] res = new int[4];
        if(Redbuff){ //有红buff
            int phyattack = 120;
            int blood = 200;
            int move = 100; //一技能效果加速
            res[0]=120;
            res[1]=200;
            res[2]=100;
        }else{ //无红buff
            int phyattack = 100;
            int blood = 0;
            int move = 100;
            res[0]=100;
            res[1]=0;
            res[2]=100;
        }

        //一技能特殊属性，沉默英雄，也就是说，被击中的英雄2s内无法释放技能。
        res[3] = 1;//标志1为该技能的效果是可以沉默；

        return res;
    }


    //亚瑟的二技能
    public static int[] Secondable(boolean Redbuff,boolean bluebuff){  //给技能一个参数，如果有红buff,那么技能属性就会提升
        int[] res1 = new int[4];

        int phyattack = 300;
        int blood = 0;
        int move = 50;
        int time1 = 7000; // 每7s ,一个二技能
        res1[0]=phyattack;
        res1[1]=blood;
        res1[2]=move ;
        res1[3]=time1;

        if(Redbuff){ //有红buff
            phyattack = 400;
            blood = 200;
            move = 50;
            res1[0]=phyattack;
            res1[1]=blood;
            res1[2]=move;
            res1[3]=time1;
        }
        if(bluebuff){ //有蓝buff
           time1 = 6000;
            res1[3]=time1;
        }


        return res1;
    }


    //亚瑟的三技能
    public static int[] Thirdable(boolean Redbuff,boolean bluebuff){  //给技能一个参数，如果有红buff,那么技能属性就会提升
        int[] res2 = new int[4];
        int phyattack = 600;
        int blood = 0;
        int move = 50;
        int time2 = 12000;  //每12s一个三技能
        res2[0]=phyattack;
        res2[1]=blood;
        res2[2]=move ;
        res2[3]=time2;
        if(Redbuff){ //有红buff
            phyattack = 800;
            blood = 400;
            move = 50;
            res2[0]=phyattack;
            res2[1]=blood;
            res2[2]=move ;
            res2[3]=time2;
        }

        if(bluebuff){ //有蓝buff
             time2 = 10000;
            res2[0]=phyattack ;
            res2[1]=blood ;
            res2[2]=move ;
            res2[3]=time2;
        }

        return res2;
    }



}
