
import java.util.*;
public class Solution {
    public static void main(String[] args) {
      String s = "google";
        System.out.println(FirstNotRepeatingChar(s));
    }

    public  static int FirstNotRepeatingChar(String str) {
        if(str==null||str.length()==0) return 0;
        ArrayList<Character> list = new ArrayList<>();

        char[] arr = str.toCharArray();

        for(int i = 0;i<arr.length;i++){
            list.add(arr[i]);
        }

        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    list.remove(i);
                    list.add(i,' ');
                    list.remove(j);
                    list.add(j,' ');
                }
            }
        }

        for(int i = 0;i<arr.length;i++){
            if(list.contains(arr[i])){
                return i;
            }
        }
        return 0;
    }


}
