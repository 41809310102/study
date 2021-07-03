import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(ReverseSentence(s));
        }
    }

    public  static  String ReverseSentence(String str) {
        if(str.length()==0||str==null) return str;
        String[] res = str.split(" ");
        String s = "";
        for(int i = res.length-1;i>=1;i--){
            s+=res[i]+" ";
        }
        s+=res[0];
        return s;
    }
}
