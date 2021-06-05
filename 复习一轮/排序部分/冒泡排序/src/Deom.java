import java.util.Arrays;

public class Deom {
    public static void main(String[] args) {
        int[] arr = {25,89,56,88,21,3,56,66,8,663,55};
         BubbleSort(arr);
    }
    public  static  void BubbleSort(int[] arr){
        if(arr.length==0||arr==null) return;
        for(int i =0;i<arr.length;i++){  //表示第一个元素
            for(int j = i+1;j<arr.length;j++){ //表示第二个元素
                if(arr[i]>=arr[j]){ //如果第一个元素大于等于第二个元素，那么两个元素进行交换，直到不满条件；
                    int temp = arr[i];
                    arr[i] =arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
