import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int x = n+2;
            System.out.println(rebbut(x));
        }
    }

    private  static  int rebbut(int n){
        if(n==1||n==2){
            return 1;
        }
        return rebbut(n-1)+rebbut(n-2);
    }
}
/*
* //就是斐波那契数列
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();

            long[] arr = new long[91];
            arr[1] = 1;
            arr[2] = 2;
            for(int i = 3;i < arr.length;i++){
                arr[i] = arr[i-1] + arr[i-2];
            }
            System.out.println(arr[n]);
        }
    }
}
*/