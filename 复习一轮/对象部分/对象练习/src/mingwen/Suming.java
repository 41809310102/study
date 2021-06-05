package mingwen;
//宿命是红色铭文，继承红色铭文属性
public class Suming  extends Red{
    private  String name="宿命";
   private float attackspeed = 0.7f;
   private float blood = 33.7f;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAttackspeed() {
        return attackspeed;
    }

    public void setAttackspeed(float attackspeed) {
        this.attackspeed = attackspeed;
    }

    public float getBlood() {
        return blood;
    }

    public void setBlood(float blood) {
        this.blood = blood;
    }

}
