import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int number=cin.nextInt();
            int result=1;//结果
            int[] arr=new int[number];//数据初始化
            for(int i=0;i<number;i++){
                arr[i]=cin.nextInt();
            }
            int[] dp=new int[number];
            dp[0]=1;
            for(int i=0;i<number;i++){
                dp[i]=1;
                for(int j=0;j<i;j++){
                    if(arr[j]<arr[i]&&dp[j]>=dp[i]){
                        dp[i]=dp[j]+1;
                        result=dp[i]>result?dp[i]:result;
                    }
                }
            }
            System.out.println(result);

        }
    }
}