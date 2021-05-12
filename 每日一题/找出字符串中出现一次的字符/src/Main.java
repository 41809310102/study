
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String arr = sc.nextLine();
            System.out.println(Found(arr));
        }
    }

    public static String Found(String arr) {
        char[] res = arr.toCharArray();
        int len = res.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (res[i] == res[j]) {
                    res[i] = ' ';
                    res[j] = ' ';
                }
            }
        }

        for (int k = 0; k < len; k++) {
           if(res[k]!=' '){
               String str;
               str = String.valueOf(res[k]);
               return  str;
           }
        }

       return "-1";
    }
}

