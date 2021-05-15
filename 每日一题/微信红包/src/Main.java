import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getvalue(arr, n));
        }
    }
    public static  int getvalue (int [] arr, int n){
        Arrays.sort(arr);
        int len = arr.length/2;
        int count=1;
        for (int i =0;i<n;i++){
            if(arr[len]==arr[i]){
                count++;
            }
        }
        if(count>len){
            return arr[len];
        }
        return 0;
    }

    }
