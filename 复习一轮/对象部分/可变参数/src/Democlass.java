
class Student{   //student是该类的名称
    private  String  name;
    private  int age;
    private  String sex;
    private  int xuehao;
    private  int school;
    //该类的属性：学生姓名，年龄，性别，学号，学校等等；

    public Student() {  //该类的无参构造方法

    }
    public Student(String  name) { //该类的有参构造方法
        this.name = name;
    }

    public void study(){ //该类的一个典型的活动，我们叫方法或函数
        System.out.println("我正在学习");
    }

}

public class Democlass {
    public static void main(String[] args) {
        Student student1 = new Student("沉默着忍受"); //实例化一个学生类，名字叫沉默着忍受
        student1.study();//调用该类的study方法，此时控制台就运行该方法；

    }
}
