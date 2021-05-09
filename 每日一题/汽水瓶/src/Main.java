import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if(n==0){
                return ;
            }
            System.out.println(Number(n));
        }
    }

    public  static  int  Number(int n){
      if(n==3||n==2){
          return 1;
      }
      if(n<2){
          return 0;
      }
      return n/2;
    }
}
