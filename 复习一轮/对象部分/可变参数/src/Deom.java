public class Deom {
    public static void main(String[] args) {
//实例化对象
     Person person = new Person("沉默着忍受");//我是一个叫沉默着忍受的人；
     Washing washing = new Washing("海尔");//我有一台海尔洗衣机
        person.makeClo(3);//我有3件脏衣服；
        String s = washing.washing(3);//放进洗衣机;
        System.out.println(s);
        System.out.println(person.liang(s));//晾衣服

    }
}
