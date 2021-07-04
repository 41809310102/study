public class Washing {
    private  String  name ;//品牌

    public Washing(String name) {
        this.name = name;
    }

    public  String  washing(int n){
        if(n<0){
            return "没有放衣服";
        }
        return "洗好了！";
    }
}
