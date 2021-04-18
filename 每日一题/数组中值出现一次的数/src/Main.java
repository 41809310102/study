

import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        for(int i=0;i<n-1;){
            if(arr[i]!=arr[i+1]){
                System.out.print(arr[i]+" ");
                break;
            }
            i=i+2;
        }
        for(int i=n-1;i>1;){
            if(arr[i]!=arr[i-1]){
                System.out.print(arr[i]);
                break;
            }
            i=i-2;
        }
    }
}
