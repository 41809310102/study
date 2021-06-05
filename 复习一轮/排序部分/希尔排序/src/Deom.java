import java.util.Arrays;

/**
 * 希尔排序
 *
 * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @param arr  待排序数组
 */

public class Deom {
    public static void main(String[] args) {
        int[] arr = {2,1,6,9,5,4,20,19,11};
         shellSort(arr);
    }

    public  static  void shellSort(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }
        int groud = arr.length/2;
        for(;groud>0;groud/=2){
            for(int i = 0;i+groud<arr.length;i++){
                for(int j = 0;j+groud<arr.length;j+=groud){
                    if(arr[j]>=arr[j+groud]){
                        int temp = arr[j];
                        arr[j] = arr[j+groud];
                        arr[j+groud] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

}
