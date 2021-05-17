import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int [][] arr = new int[n][n];
            for(int i =0 ;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
              int[][] arr1=matrixPower(arr,n);
              String res = String.valueOf(arr1[0][0]);
              int len = res.length();
              if(len>4){
                  for(int i = len;i>=len-4;i--){
                      System.out.print(res.charAt(i));
                  }
              }else {
                  String s ="0";
                  System.out.println(s+res);
              }
            }
        }


    public static int[][] twoMatrixPlus(int x [][],int y [][]) {//两个矩阵相乘,具有普适性
        int ans[][]=new int[x.length][y[0].length];
        for(int i=0;i<ans.length;i++)
            for(int j=0;j<ans[0].length;j++) {
                ans[i][j]=0;
            }//初始化
        for(int i=0;i<x.length;i++)
            for(int j=0;j<y[0].length;j++)
                for(int p=0;p<x[0].length;p++)
                    ans[i][j]+=x[i][p]*y[p][j];
        return ans;

    }

    public static int[][] matrixPower(int a[][],int n){
        int ans[][]=new int[a.length][a[0].length];
        for(int i=0;i<ans.length;i++)
            for(int j=0;j<ans[0].length;j++) {
                if(i==j)
                    ans[i][j]=1;
                else
                    ans[i][j]=0;
            }//初始化为单位矩阵
        while(n!=0) {
            if((n&1)==1)
                ans=twoMatrixPlus(ans,a);
            a=twoMatrixPlus(a,a);
            n=n>>1;
        }
        return ans;
    }
*/


        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Scanner in = new Scanner(System.in);
            int [] a = new int[10001];
            a[0]=1;
            a[1]=1;
            for(int i=2;i<10001;i++){
                a[i]=(a[i-1]+a[i-2])%10000;
            }
            while(in.hasNext()){
                int N = in.nextInt();
                for(int i=0;i<N;i++){
                    int tmp = in.nextInt();
                    System.out.printf("%04d",a[tmp]);
                }
                System.out.println();
            }
        }



}
