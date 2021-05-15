import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String  a = sc.nextLine();
            String  b = sc.nextLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = new int[m+1][n+1];
            for(int i = 1;i<=m;i++){
                dp[i][0] = i;
            }
            for(int j = 1;j<=n;j++){
                dp[0][j] = j;

            }
            for (int i = 1;i<=m;i++){
                for(int j = 1;j<=n;j++){
                    if(a.charAt(i-1)==b.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }else {
                        dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    }
                }
            }
            System.out.println(dp[m][n]);
        }
    }
}
