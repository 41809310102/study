import java.util.Scanner;
/**
 * iNOC产品部-杨辉三角的变形
 * @author Cshuang
 * 看规律
 */
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            if(n<=2)
                System.out.println(-1);
            else if(n%2==1)
                System.out.println(2);
            else if(n%4==0)
                System.out.println(3);
            else
                System.out.println(4);
        }
        in.close();
    }
}
/*
* public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            int[][]a=new int[n][2*n-1];
            //将杨辉三角补0，使之变为长方形
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2*n-1; j++) {
                    a[i][j]=0;
                }
            }
            a[0][n-1]=1;//第一行中间的数为1
            a[n-1][0]=a[n-1][2*n-2]=1;//第n行的第一个数和最后一个数为1

            for (int i = 1; i < n; i++) {
                //之所以只到了2n-2,避免越界，因为每一行有2n-1个元素，而除了最后一行外，其他行的第2n-1个元素是0
                //而最后一行的最后一个元素（第2n-1个元素，编号2n-2）已经初始化,所以可以跳过去
                for (int j = 1; j < 2*n-2; j++) {
                    a[i][j]=a[i-1][j-1]+a[i-1][j]+a[i-1][j+1];
                }
            }
            for (int i = 0; i < 2*n-1; i++) {
                if(a[n-1][i]%2==0&&a[n-1][i]!=0){
                    System.out.println(i+1);
                    break;
                }else if(i==2*n-2){
                    System.out.println(-1);
                }
            }
        }
        in.close();
    }
}
