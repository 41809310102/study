import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
      int[] res = {1,2,1,3,2,5,4,5};
        System.out.println(Arrays.toString(found(res)));

    }

    public  static  int[] found(int[] arr){
        if(arr==null||arr.length==0) return arr;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(list.indexOf(arr[i])==-1){
                list.add(arr[i]);
            }else{
                list.remove(list.indexOf(arr[i]));
            }
        }
        return  new int[]{list.get(0),list.get(1)};
    }
}
