



public class Demo {
    public static void main(String[] args) {
        String s = new String("1");
        String s1 = new String("1");
        System.out.println("使用==");
        if(s==s1){
            System.out.println("s==s1");
        }else{
            System.out.println("s!=s1");
        }
        System.out.println("======================");
        System.out.println("使用equals");
        if(s.equals(s1)){
            System.out.println("s==s1");
        }else {
            System.out.println("s!=s1");
        }

    }


}
/*
* 结果：
*s!=s1

Process finished with exit code 0
* */