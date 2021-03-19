import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.print("输入绳子的长度：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Demo sb = new Demo();
        System.out.println(sb.Cut(n));
    }

    public long Cut(int n){
        if(n<2) return  0;
        if(n==2) return 1;
        if(n==3) return  2;
        int time3 = n/3;
        if(n-time3*3==1){
            time3 -=1;
        }
        int time2 = (n-time3*3)/2;
        return  (long)Math.pow(3,time3)*(long)Math.pow(2,time2);
    }
}
