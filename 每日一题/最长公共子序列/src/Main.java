//Date:6.1
//最长公共子串
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            System.out.println(LCS(str1, str2));
        }
        sc.close();
    }

    private static int LCS(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int[][] res = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int cur = 0;
                if (str1.charAt(i) == str2.charAt(j))
                    cur++;

                res[i + 1][j + 1] = maxNum(res[i][j] + cur, res[i][j + 1], res[i + 1][j]);

            }
        }
        return res[len1][len2];
    }

    /*
     * 返回三者最大值
     */
    private static int maxNum(int i, int j, int k) {
        int max = i;
        max = j > max ? j : max;
        max = k > max ? k : max;
        return max;
    }

}