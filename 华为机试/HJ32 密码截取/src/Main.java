import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(longgest(s));
        }
    }
    public static int longgest(String s){
        int len = s.length();
        if(s==null||s.length()==0) return 0;
        String res = null;
        boolean[][]dp = new boolean[len][len];
        for(int i = len-1;i>=0;i--){
            for(int j = i;j<len;j++){

                dp[i][j] = s.charAt(i)==s.charAt(j)&&(j-i<3||dp[i+1][j-1]);
                //判断从s(i)和S（j）是否相等并且s(i+1)-s(j-1)是一个回文字符串；

                if(dp[i][j]&&(res==null||j-i+1>res.length())){
                    res = s.substring(i,j+1);
                }
                //dp是一个回文，并且当前长度大于之前记录的长度；
            }
        }
        return res.length();
    }
}