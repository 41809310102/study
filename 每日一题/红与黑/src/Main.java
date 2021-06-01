// write your code here
import java.util.*;
public class Main{
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            String[][] arr = new String[m][n];
            for (int i = 0; i <m; i ++ ) {
                for (int j = 0; j <n; j ++ ) {
                    String s = sc.nextLine();
                    arr[i][j] = s;
                }
            }
            int[] res = foundLoction(arr);
            int m1 = res[0];
            int n1 = res[1];
            System.out.println(movingCount(m, n, m1, n1, arr));


        }
    }

    public  static  int[] foundLoction(String[][] arr){
        if(arr==null||arr.length==0&&arr[0].length==0){
            return null;
        }

        int[] res = new int[2];
        for(int i = 0;i<arr.length;i++){
            for(int j =0;j<arr[0].length;j++){
                if(arr[i][j].equals("@")){
                    res[0] = i;
                    res[1] =j;
                    break;
                }
            }
        }
        return res;
    }



    public  static  int movingCount(int m,int n,int m1,int n1,String[][] arr) {
        if (m <= 0 || n <= 0) return 0;
        boolean[] visited = new boolean[m * n];
        for (int i = 0;i<m*n;i++){
            if(i==m1*n+n1){
                visited[i] = true;
            }
            visited[i] = false;
        }
        int count = movingCountCore(m,n,m1,n1,visited,arr);
        return count;
    }



    public  static int  movingCountCore(int m,int n,int m1,int n1,boolean[] visited,String[][] arr){
        int count =0;
        if(check(m,n,m1,n1,visited,arr)){
            visited[m1*n+n1]=true;
            count=1+movingCountCore(m,n,m1-1,n1,visited,arr)
                    +movingCountCore(m,n,m1,n1-1,visited,arr)
                    +movingCountCore(m,n,m1+1,n,visited,arr)
                    +movingCountCore(m,n,m1,n1+1,visited,arr);
        }
        return count;

    }

    private static boolean check(int m, int n, int m1, int n1, boolean[] visited,String[][] arr) {
        if(m1>=0&&m1<m&&n1>=0&&n1<n&&!visited[m1*n+n1]&&!arr[m1][n1].equals("#")){
            return true;
        }
        return false;
    }



}
