

// 经典dp问题
// 假设dp[n]表示以n为最后一个元素的子数组和的最大值，
// 因此， dp[n] = max(dp[n-1],0)+num[n];
// 当然实现的时候，没有必要设置一个数组保存所有的情况，因为只是用到了前一个位置的
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while(sc.hasNext()){
            n = sc.nextInt();
            int[] num = new int[n];
            for(int i=0;i<n;i++){
                num[i] = sc.nextInt();
            }
            int max = num[0];
            int sum = num[0];
            for(int i=1;i<n;i++){
                if(sum>=0){
                    sum += num[i];
                }else{
                    sum=num[i];
                }
                if(sum>max)max=sum;
            }
            System.out.println(max);
        }
    }
}