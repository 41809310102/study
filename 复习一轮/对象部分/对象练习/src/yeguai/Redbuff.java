package yeguai;
//红buff
public class Redbuff {
    private  int phyattack = 200; //物理攻击加200；
    private  int move = 50; //降低被攻击英雄的移速；
    private  int attack = 50; //红buff被动烧伤；

    public int getPhyattack() {
        return phyattack;
    }

    public void setPhyattack(int phyattack) {
        this.phyattack = phyattack;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
