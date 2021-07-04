public class Person {
    private int age; //年龄
    private int hight;//身高
    private String sex;//性别
    private String name;//姓名
//构造方法；
    public Person(String name) {
        this.name = name;
    }
 //脏衣服
    public  int  makeClo(int n){
        if(n<0){
            return -1;
        }
        return n;
    }

    //晾衣服

    public  String  liang(String res){
        if(res.equals("洗好了！")){
            return "我把衣服晾了！";
        }else{
            return "没有衣服！";
        }
    }

}
