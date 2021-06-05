import java.util.Arrays;

public class Deom {
    /**
     * 插入排序
     */

    public static void main(String[] args) {
        int[] arr = {25,89,56,88,21,3,56,66,8,663,55};
        //insertionSort(arr);
        insertionSort1(arr);
    }
    //序列较少的情况下：
    public  static  void insertionSort(int[] arr){
       if(arr==null||arr.length==0) return;
       for(int i =1;i<arr.length;i++){
           int temp = arr[i]; //取出第二个元素；
           for(int j =i;j>=0;j--){
              if(j>0&&arr[j-1]>temp){//j-1为当前元素的前一个元素的下标，如果前一个数大于当前的元素，那么两个数据进行交换
                  arr[j] = arr[j-1];
                  System.out.println("inserting"+Arrays.toString(arr));
              }else{
                  arr[j]=temp;//如果大于或等于，那么保存当前数，并且进入下一次插入；
                  System.out.println("Sorting"+Arrays.toString(arr));
                  break;
              }

           }
       }
    }
//数据量比较多的时候
    public  static  void insertionSort1(int[] arr){
        if(arr.length==0||arr==null) return;
        for(int i =0;i<arr.length-1;i++){
            for(int j = i+1;j>0;j--){
                if(arr[j-1]<arr[j]){
                    break;
                }
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
