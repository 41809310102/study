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
}
