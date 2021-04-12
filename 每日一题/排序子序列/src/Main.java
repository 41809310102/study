import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a[] = new int[300000];
        int b[] = new int[300000];
        while (input.hasNext()) {
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                b[i] = a[i];
            }
        }
        Arrays.sort(a, 0,  a.length);
        int count =1;
       for(int i =0;i<a.length;i++){
           if(b[i]!=a[2]){
               count++;
           }
       }
        System.out.println(count);
        }
    }
