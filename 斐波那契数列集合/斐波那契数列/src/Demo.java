
//斐波那契数

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        int n = sb.nextInt();
        Demo demo = new Demo();
        System.out.println(demo.Find1(n));
    }
 //递归实现
    public  int Find(int n){
       if(n<=0) return 0;
       if(n==1) return 1;
        return Find(n-1)+Find(n-2); //时间复杂对高
    }
    //非递归
    public  int Find1(int n){
       int[] res = {0,1};
       if(n<2) return res[n];
       int one = 1;
       int two = 0;
       int num=0;
       for(int i=2;i<=n;i++){   //缓存，可以简化递归，时间复杂对低
           num = one+two;
           two = one;
           one = num;
       }
       return  num;
    }
}
