import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if(isshunumber(n)){
                System.out.println(1);
                continue;
            }
           int count=0;
            for(int i =2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    while (n%i==0){
                         n=n/i;
                    }
                    count++;
                }
            }
            if(n!=1){
                count++;
            }
            System.out.println(count);
        }
    }

    public  static  boolean isshunumber(int n){
        for(int i = 2;i<=Math.pow(n,0.5);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
