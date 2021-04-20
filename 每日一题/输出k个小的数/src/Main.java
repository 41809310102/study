import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num =new int[200];
        int i=0;
        while (sc.hasNextInt()&&i<=200) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            num[i]= sc.nextInt();
            i++;
        }
        for(int j = 0;j<num.length; j++){
            System.out.println(num[j]+" ");
        }
        /*int len = num.length-1;
        int res =num[len];

        Arrays.sort(num);
        for(int j = 0;j<res; j++){
            System.out.println(num[j]+" ");
        }*/
    }
}