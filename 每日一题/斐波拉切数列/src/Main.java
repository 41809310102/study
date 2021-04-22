import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Main sb = new Main();
        System.out.println(sb.Find1(n));


    }
        //非递归
        public  int Find1(int n){
            int[] res = {0,0};
            if(n<2) return res[n];
            int one = 1;
            int two = 0;
            int num=0;
            for(int i=2;i<=n;i++){   //缓存，可以简化递归，时间复杂对低
                num = one+two;
                two = one;
                one = num;
                int a1 =n-two;
                int a2 =one-n;
                if(one>=n&&a1<=a2){
                    return a1;
                }
                if(one>=n&&a1>a2){
                    return a2;
                }

            }
          return 0;
        }
    }


