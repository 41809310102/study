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
        Shoe shoe = new Shoe();
        Fajia fajia = new Fajia();
        Anyinzhanfu anyinzhanfu = new Anyinzhanfu();
       
    }
}
