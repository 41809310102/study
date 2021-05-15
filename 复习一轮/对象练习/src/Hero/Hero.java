package Hero;

//英雄的基本属性
public class Hero {
    public String  name; //英雄的名字
    public String type; //英雄的职业
    public int blood; //英雄的基本血量
    public int phyattack; //英雄的基本物理攻击
    public int Magicattavk; //英雄的基本法术攻击
    public int phyfangyu; //英雄的基础防御
    public int attavknum; //普通伤害的值
    public int move; //移动速度
    public int money; //经济

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Hero(String name, String type, int blood, int phyattack, int magicattavk, int phyfangyu, int attavknum, int move, int money) {
        this.name = name;
        this.type = type;
        this.blood = blood;
        this.phyattack = phyattack;
        this.Magicattavk = magicattavk;
        this.phyfangyu = phyfangyu;
        this.attavknum= attavknum;
        this.move= move;
        this.money= money;
    }

    public Hero() {

    }

    public String  getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getBlood() {
        return blood;
    }

    public int getPhyattack() {
        return phyattack;
    }

    public int getMagicattavk() {
        return Magicattavk;
    }

    public int getPhyfangyu() {
        return phyfangyu;
    }

    public int getAttavknum() {
        return attavknum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void setPhyattack(int phyattack) {
        this.phyattack = phyattack;
    }

    public void setMagicattavk(int magicattavk) {
        Magicattavk = magicattavk;
    }

    public void setPhyfangyu(int phyfangyu) {
        this.phyfangyu = phyfangyu;
    }

    public void setAttavknum(int attavknum) {
        this.attavknum = attavknum;
    }

    //受到普通攻击
    public  int  bnormalAttack(int attavknum){
        if(this.phyfangyu-this.attavknum<=0){
            int res = this.phyfangyu-this.attavknum;
            return  this.blood+res;
        }
        return blood-this.attavknum;
    }
    //普通攻击
    public  int  znormalAttack(){
        if(this.type=="射手"||this.type=="战士"||this.type=="刺客"){
            this.attavknum+=phyattack;
        }
        if(this.type=="法师"){
            this.attavknum+=Magicattavk;
        }
       return attavknum;
    }
}
