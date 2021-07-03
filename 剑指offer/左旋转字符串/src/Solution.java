import java.util.*;
public class Solution {


    public static void main(String[] args) {
        Scanner SC = new Scanner(System.in);
        while (SC.hasNext()){
            String s = SC.nextLine();
            System.out.println(LeftRotateString(s, 3));
        }

    }


    public static String LeftRotateString(String str,int n) {
        if(str.length()==0||str==null) return
        char[] res = str.toCharArray();
       while (n>0){
           change(res);
           n--;
       }
       return  new String(res);
    }

    public static void change(char[] arr){
        char s = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = s;
    }
}