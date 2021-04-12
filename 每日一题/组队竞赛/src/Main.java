
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a[] = new int[300000];
        while (input.hasNext()) {
            int n = input.nextInt();
            for (int i = 0; i < n * 3; i++) {
                a[i] = input.nextInt();
            }
            Arrays.sort(a, 0, 3 * n);
            int end = 3 * n - 1;
            int begin = 0;
            long sum = 0;
            while (end > begin) {
                sum = sum + a[end - 1];
                end = end - 2;
                begin = begin + 1;
            }
            System.out.println(sum);
        }
    }
}