
//青蛙跳台阶，本质上是斐波那契数列。

import java.util.Scanner;

/**
 *我们把n级台阶时得跳法看成n的函数，记为F（n），当n>2时，第一次跳的时候就有两种结果，因此n
 * 级台阶的不同跳法的总数为f(n)=f(n-1)+f(n-2);
 *
 */


public class Demo {
    public static void main(String[] args) {
        System.out.print("输入要跳的台阶数：");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        Demo sb = new Demo();
        System.out.println(sb.Find(n));
    }

    public  int Find(int n){
        int[] res = {0,1};
        if(n<2) return  res[n];
        int one = 1;
        int two = 0;
        int num = 0;
        for (int i=2;i<=n;i++){
            num = one+two;
            two = one;
            one = num;
        }
        return  num;
    }

}
