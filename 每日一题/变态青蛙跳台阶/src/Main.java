import java.util.Scanner;
//f(n) = 2>*n-1
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(feiBei(n));
        }

    }
    public  static  int feiBei(int n){
        if(n<=0){
            return 0;
        }
        int sum =1;
        while (n-1>=0){
            sum = sum*2;
            n--;
        }
          return sum;
    }
}
