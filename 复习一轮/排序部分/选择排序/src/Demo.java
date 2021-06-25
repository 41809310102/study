import java.util.Arrays;

public class Demo {
    //选择排序
    /**
     *1.从待排序序列中，找到关键字最小的元素；
     * 2.如果最小元素不是待排序序列的第一个元素，将其和第二个元素交换；
     * 3.从余下的N-1个元素中，找出关建字最小的元素，重复1.2步骤，直到排序排序结束
     * 当增量因子微一时，整个序列长度为原来序列的长度；
     */

    public static void main(String[] args) {
        int[] arr  = {25,89,56,88,21,3,56,66,8,663,55};
    //    Selectionchose(arr);
        System.out.println("========================");
        int[] res = Selectchose1(arr);
       // System.out.println(Arrays.toString(res));
        chosesort(arr);

    }
//展示选择的过程
    public  static  void Selectionchose(int[] arr){
        if(arr==null||arr.length==0) return;
        //开始遍历，寻找最小的元素，打印出来
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min =j;
                }
            }
            if(min!=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }
//直接返回最终结果
    public static  int[] Selectchose1(int[] arr){
        if(arr==null||arr.length==0){
            System.out.println("序列不合法！");
            return null;
        }
        for(int i =0;i<arr.length-1;i++){
            int min = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min =j;
                }
            }
            if(min!=i){
                int res = arr[i];
                arr[i] = arr[min];
                arr[min] = res;
            }
        }
       return arr;
    }


    public  static  void  chosesort(int[] arr){
        if(arr==null||arr.length==0) return;
        for(int i = 0;i<arr.length;i++){
            int min = i;
            for(int j =i+1;j<arr.length;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }

            if(min!=i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] =temp;
             }
        }
        System.out.println(Arrays.toString(arr));
    }
}


