package yeguai;
//蓝buff
public class Bluebuff {
    private  int  cool = 2000; //蓝buff可以缩短技能冷却
    private  int  blue = 1000; //buff有回蓝效果；

    public int getCool() {
        return cool;
    }

    public void setCool(int cool) {
        this.cool = cool;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
