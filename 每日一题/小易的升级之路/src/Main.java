import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int attack = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0;i<arr.length;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(Shengji(arr, n, attack));
        }


    }

    public  static  int  Shengji(int[] arr,int n,int attack){

        if(arr==null||arr.length==0) return attack;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]<=attack){
                attack+=arr[i];
            }else{
                attack += MaxNumber(arr[i],attack);
            }
        }
        return attack;
    }

    private static int MaxNumber(int m, int n) {
        if(m<n){
            int tmp = m;
            m=n;
            n = tmp;
        }
        while (m%n!=0){
            int tmp = m%n;
            m = n;
            n = tmp;
        }
        return n;
    }


}
