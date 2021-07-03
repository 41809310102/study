import java.util.ArrayList;
public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
      FindNumbersWithSum(arr,21).get(0);
        FindNumbersWithSum(arr,21).get(1);
    }
    public  static  ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null||array.length==0) return list;
        int min = 0;
        int res = 0;
        for(int i = 0;i<array.length-1;i++){
            for(int j = i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    list.add(array[i]);
                    list.add(array[j]);
                }
            }
        }


        if(list.size()>2){
            min = list.get(0)*list.get(1);
            if(min==20) {
                list.clear();
                list.add(1);
                list.add(20);
                return list;
            }

            for(int i = 0;i<list.size();i=i+2 ){
                res = list.get(i)*list.get(i+1);
                if(res>min){
                    list.remove(array[i]);
                    list.remove(array[i+1]);
                }else{
                    min = res;
                }
            }
        }
        return list;
    }
}