import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        //FoundMax(arr);
       // FoundAvg(arr);
        //FoundStation(arr,2);
        //Founder(arr,8);
       /*int[] res =  Nixu(arr);
       for(int i=0;i<res.length;i++){
           System.out.print(arr[i]+" ");
       }*/
        System.out.println(Arrays.toString(Port(arr)));
    }
//求最大值
    public  static void  FoundMax(int[] arr){
        Arrays.sort(arr);
        int len = arr.length;
        System.out.println(arr[len - 1]);
    }
//求平均值
    public  static  void FoundAvg(int[] arr){
        int sum = 0;
        int len = arr.length;
        for(int i = 0;i<len;i++){
            sum +=arr[i];
        }
        float avg =(float)sum/len;
        System.out.println(avg);
    }
//查找指定的元素的位置
    public  static  void FoundStation(int [] arr,int pos){
        int len = arr.length;
        for(int i = 0;i<len;i++){
            if(pos == arr[i]){
                System.out.println(i);
                return;
            }
        }
    }
//二分查找
    public  static  void Founder(int[] arr,int pos){
        int left = 0;
        int right = arr.length;
        int mid = (left+right)/2-1;
        System.out.println(mid);
        while (left<right){
            if(arr[mid]==pos){
                System.out.println(mid);
                return;
            }
            if(arr[mid]>pos){
                right = mid;
                mid = (right+left)/2;
                left++;
            }
            if(arr[mid]<pos){
                left = mid;
                mid = (right+left)/2;
                right--;
            }
        }
    }
    //数组逆序
    public  static  int[] Nixu(int[] arr){
        int len = arr.length;
        int mid = len/2;
        for(int i = 0;i<=mid;i++){
            int res = arr[len-1-i];
            arr[len-1-i] = arr[i];
            arr[i] = res;
        }
        return arr;
    }

    //交换数组中奇数和偶数的位置，奇数在前，偶数在后
   public  static  int[] Port(int[] arr){
        int i = 0;
        int j =arr.length-1;
        while (i<j){
            while (i<j&&arr[i]%2==0){
                i++;
            }
            if(i>=j){
                return arr;
            }else {
                while (i < j && arr[i] % 2 != 0) {
                    j--;
                }
                if(i>=j){
                    return arr;
                }else {
                    int res = arr[j];
                    arr[j] = arr[i];
                    arr[i] = res;
                }
            }
        }
        return arr;
   }

}
