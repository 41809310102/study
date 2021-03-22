import java.util.*;
import java.util.Stack;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组 
     * @return int整型一维数组
     */

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8,9,10,13};
        Solution sb = new Solution();
        int[] ren = new int[100];
        ren=sb.reOrderArray(num);
        for (int i = 0;i<ren.length;i++){
            System.out.print(ren[i]+" ");
        }
    }
    public int[] reOrderArray (int[] array) {
        // write code here
        if(array==null||array.length==0) return null;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<array.length;i++){
            if(array[i]%2==0){
                stack.push(array[i]);
            }
        }
        for(int i =0;i<array.length;i++){
            if(array[i]%2!=0){
                stack.push(array[i]);
            }
        }
        int n =0;
        while (stack.size()>0&&n<=array.length-1){
            array[n]=stack.pop();
            n++;

        }
        //排序
        int mid = (array.length-1)/2;
        for(int i =0;i<=mid;i++){
            for(int j =i;j<=mid;j++){
                if(array[i]>array[j]){
                    int res = array[i];
                    array[i] = array[j];
                    array[j] = res;

                }
            }
        }
        int len =  mid+1;
        for(int k =len;k<array.length;k++){
            for(int q =k;q<array.length;q++){
                if(array[k]>array[q]){
                    int res = array[k];
                    array[k] = array[q];
                    array[q] = res;

                }
            }
        }
        return  array;
    }

}