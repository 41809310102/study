import java.nio.file.Watchable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {38,20,32,9,22,21,1,23,121};
        int k = 4;

        System.out.println(GetLeastNumbers_Solution(arr, k).toString());
    }
    public  static  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int len = input.length;
        if(k>len) return res ;
        if(input==null) return res;
        Arrays.sort(input);
        for(int i = 0;i<k;i++){
                res.add(input[i]);
        }
        return res;
    }
}
