import java.util.Scanner;

public class Deom {
    public static void main(String[] args) {
        System.out.print("输入2*n个格子：");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Deom sb = new Deom();
        System.out.println(sb.Find(number));
    }
    public  int Find(int number){
        int[] res = {0,1};
        if(number<2) return res[number];
        int one = 1;
        int two = 0;
        int num = 0;
        for (int i=2;i<=number;i++){
            num = one+two;
            two = one;
            one = num;

        }
        return  num;
    }
}
