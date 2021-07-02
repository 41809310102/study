import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(foundNumber(n));
        }
    }
    /*丑数的定义是1或者因子只有2 3 5，可推出丑数=丑数*丑数，假定丑数有序序列为：a1,a2,a3.......an
    所以可以将以上序列（a1除外）可以分成3类，必定满足：
    包含2的有序丑数序列：2*a1, 2*a2, 2*a3 .....
    包含3的有序丑数序列：3*a1, 3*a2, 3*a3 .....
    包含5的有序丑数序列：5*a1, 5*a2, 5*a3 .....
    以上3个序列的个数总数和为n个，而且已知a1 = 1了，将以上三个序列合并成一个有序序列即可*/
    public  static  int foundNumber(int n){
        if(n==0) return 0;
        int[] arr = new int[n];
        int t2=0,t3=0,t5=0;
        arr[0] = 1;
        for(int i = 1;i<n;i++){
            arr[i] = Math.min(Math.min(arr[t2]*2,arr[t3]*3),arr[t5]*5);
            if(arr[i]==arr[t2]*2) t2++;
            if(arr[i]==arr[t3]*3) t3++;
            if(arr[i]==arr[t5]*5) t5++;
        }
        return arr[n-1];
    }

    public  static int  GetUglyNumber_Solution(int index) {
        if(index==0)return 0;
        int[] res=new int[index];
        int t2=0,t3=0,t5=0;
        res[0]=1;
        for(int i=1;i<index;i++){
            res[i]=Math.min(Math.min(res[t2]*2,res[t3]*3),res[t5]*5);
            if(res[i]==res[t2]*2) t2++;
            if(res[i]==res[t3]*3) t3++;
            if(res[i]==res[t5]*5) t5++;
        }
        return res[index-1];
    }
}
