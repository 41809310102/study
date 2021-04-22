import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            double num=1;
         while (n!=0){
             num = num*n;
             n = n-1;
         }
            System.out.println(Number(num));


        }
    }
    public  static  int Number(double n){

        int count=0;
        while (n%10==0){
            count++;
            n = n/10;
        }
        return count;
    }
}
