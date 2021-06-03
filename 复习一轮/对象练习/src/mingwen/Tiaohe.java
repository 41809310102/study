package mingwen;
//调和是蓝色铭文，继承蓝色铭文属性
public class Tiaohe extends Blue{
    private  String name="调和";
    private float blood = 450.0f; //基础生命值
    private float makeBlool = 52; //每秒回血52

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBlood() {
        return blood;
    }

    public void setBlood(float blood) {
        this.blood = blood;
    }

    public float getMakeBlool() {
        return makeBlool;
    }

    public void setMakeBlool(float makeBlool) {
        this.makeBlool = makeBlool;
    }
}
