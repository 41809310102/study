import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        System.out.println("统计一个整数二进制中1的个数");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Demo sb = new Demo();
        System.out.println(n+"中1的个数为"+sb.Found(n));
    }

    public  int Found (int n ){
        int count =0;
        while(n!=0){
            ++count;
            n=n&(n-1);
        }
        return count;
    }
}
