package mingwen;
//虚空是绿色铭文，继承绿色铭文属性
public class Xukong extends Green {
    private  String name="虚空";
    private  float blood = 37.5f;
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
}
