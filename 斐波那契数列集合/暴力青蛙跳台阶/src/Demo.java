/*
* 如果把青蛙跳台阶的条件改为：一只青蛙一次可以跳上1个台阶，也可以跳上2级........它也可以跳上n级，此时该青蛙跳上一个
* n级台阶总共有多少种跳法；我们不难发现，如果是8个台阶
* 也就是1（2+3+4+5+6+7+8）+2（+3+4+5+6+7+8）.........及就是F(n) =2 的n-1次方*/


import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        int n = SC.nextInt();
        Demo sb = new Demo();
        System.out.println(sb.BlFind(n));
    }
    public  int BlFind(int n){
        if(n==0)  return 0;
        if(n==1)  return  1;
        if(n==2)  return  2;
        int num =2;
        while(n-1>=2){
            num=num*2;
            n--;
        }
        return num;
    }
}
