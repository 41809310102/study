import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int ber = in.nextInt();
            int n = 2;
            int count=0;
            while (n <= ber) {
                int s = 0;
                for (int i = 1; i < n; i++) {
                    if (n % i == 0) { //除的开就是因子
                        s += i; //计算这个数的因子之和
                    }
                }
                if (s == n) {
                    count++;
                }
                n++;
            }
            System.out.println(count);
        }
    }
}

