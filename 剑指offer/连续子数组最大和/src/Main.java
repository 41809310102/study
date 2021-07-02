import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }
   //动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array==null) return 0;
        int res = array[0];
        int len = array.length;
        int[] dp = new int[len];
        dp[0] = array[0];
        for(int i = 1;i<len;i++){
            dp[i] = Math.max(dp[i-1],0)+array[i];
            res = Math.max(res,dp[i]);
        }
        return res;
    }
  //双子针
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0],record = 0;
        int slow = 0,fast = 0;
        while(fast<array.length){
            record+=array[fast];
            if(max<record){
                max = record;
            }
            if(array[slow]+array[fast]<0){
                record -= array[slow];
                slow++;
            }
            fast++;
        }
        return max;
    }
}
