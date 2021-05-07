import java.util.Scanner;

public class Main {
    //计算兔纸的个数；

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(MyFound(n));
        }
    }

    public static  int MyFound(int n){
      if(n==0) return 0;
      if(n==1||n==2){
          return 1;
      }else {
          return  MyFound(n-1)+MyFound(n-2);
      }
    }

}
