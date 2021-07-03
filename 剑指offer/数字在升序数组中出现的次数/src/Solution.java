import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] arr  = {1,1,2,2,2,3,3,4,4,4,4,4,5,6};
        System.out.println(GetNumberOfK(arr, 4));
    }
    public static int GetNumberOfK(int [] array , int k) {
        if(array.length<=0||array==null) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            list.add(array[i]);
        }
        int count=0;
        for(int i=0;i<array.length;i++){
            if(k==list.get(i)){
                count++;
            }
        }

        return count;
    }
}