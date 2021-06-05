package zhuangbei;
//抵抗之靴
/**
 * 效果：减低敌方的攻击，也就是增加自己的物防
 */

public class Shoe {
    public  String name = "抵抗之靴";
    public  int phyattack=200;
    public  int mckattack=0;
    public  int move = 200;//英雄移动速度+200；

    public Shoe() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhyattack() {
        return phyattack;
    }

    public void setPhyattack(int phyattack) {
        this.phyattack = phyattack;
    }

    public int getMckattack() {
        return mckattack;
    }

    public void setMckattack(int mckattack) {
        this.mckattack = mckattack;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }
}
