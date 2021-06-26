import java.util.Arrays;

public class Mysort {
    public static void main(String[] args) {
        int[] arr ={556,6556,3556,8,778,5856,77,5,65};
        int[] res = insertSort(arr);
        System.out.println(Arrays.toString(res));
    }
    //选择排序接口
    public  static  int[] chooseSort(int[] arr){
        if(arr==null||arr.length==0) return  arr;
        for(int i = 0;i<arr.length;i++){
            int min  = i;
            for(int j = 0;j<arr.length;j++){
                if(arr[min]<=arr[j]){
                    min = j;
                }

                if(min!=i){
                    int temp = arr[min];
                    arr[min] = arr[i];
                    arr[i]   = temp;
                 }
            }
        }
        return  arr;
    }

    //插入排序
    public  static  int[] insertSort(int[] arr){
        if(arr.length==0||arr==null) return arr;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j>0;j--){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j]   = temp;
                }
            }
        }
        return  arr;
    }
}
