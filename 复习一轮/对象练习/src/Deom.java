import Hero.Hero;
import yeguai.Bird;
import yeguai.Heixie;
import yeguai.Pig;
import yeguai.Xiaobing;
import zhuangbei.Anyinzhanfu;
import zhuangbei.Fajia;
import zhuangbei.Shoe;

public class Deom {
    public static void main(String[] args) {
         Hero yase = new Hero("亚瑟","战士",1000,200,0,500,200,50,0);

         System.out.println(yase.name);
        System.out.println(yase.money);
        //开始发育(先产生野怪，小兵，河蟹的实例化对象)
        Pig pig1 = new Pig();
        Bird Bird = new Bird();
        Xiaobing xiaobing = new Xiaobing();
        Heixie heixie = new Heixie();
        for(int i =0;i<=10;i++){  //打了10轮
            yase.money+=pig1.getNum()+Bird.getNum()+xiaobing.getNum()+heixie.getNum();
        }
        System.out.println(yase.name+"的经济现在是"+yase.money);

        //开始创建装备类
        System.out.println("购买装备前：");
        System.out.println(yase.name+"当前的属性"+"生命值："+yase.blood+"物理攻击："+yase.phyattack+"法术攻击："+yase.Magicattavk+
                " 物理防御："+yase.phyfangyu+"移动速度："+yase.move);

        if(yase.money>=200){
            Shoe shoe = new Shoe();
            System.out.println(yase.name+"购买了"+shoe.name);
            yase.phyfangyu+=shoe.getPhyattack();
            yase.move+=shoe.getMove();
            yase.money=yase.money-200;
        }
        if(yase.money>=1200){
            Fajia fajia = new Fajia();
            System.out.println(yase.name+"购买了"+fajia .name);
            yase.phyattack+=fajia.getPhyattack(); //攻击力+
            yase.phyfangyu+=fajia.getPhyfanyu();  //防御力+
            yase.money=yase.money-1200;
        }
        if(yase.money>=2000){
            Anyinzhanfu anyinzhanfu = new Anyinzhanfu();
            System.out.println(yase.name+"购买了"+anyinzhanfu.name);
            yase.phyattack+=anyinzhanfu.getPhyattack(); //攻击力+
            yase.blood+=anyinzhanfu.getBlood();  //生命力+
            yase.money=yase.money-2000;
        }
        System.out.println("购买装备后：");
        System.out.println(yase.name+"当前的属性"+"生命值："+yase.blood+"物理攻击："+yase.phyattack+"法术攻击："+yase.Magicattavk+
                " 物理防御："+yase.phyfangyu+"移动速度："+yase.move);
    }
    //亚瑟的一技能
    public int[] Firstable(boolean Redbuff){  //给技能一个参数，如果有红buff,那么技能属性就会提升
        int[] res = new int[3];
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
    public int[] Secondable(boolean Redbuff){  //给技能一个参数，如果有红buff,那么技能属性就会提升
        int[] res = new int[2];
        if(Redbuff){ //有红buff
            int phyattack = 400;
            int blood = 200;
            int move = 50;
            res[0]=400;
            res[1]=200;
            res[2]=50;
        }else{ //无红buff
            int phyattack = 300;
            int blood = 0;
            int move = 50;
            res[0]=300;
            res[1]=0;
            res[2]=50;
        }
        return res;
    }


}
