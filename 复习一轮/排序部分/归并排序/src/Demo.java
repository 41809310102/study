import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
       int[] arr = {1,5,3,8,4,6,15,3,24};
        System.out.println("归并排序前"+Arrays.toString(arr));
        //System.out.println("归并排序后"+Arrays.toString(mergeSort(arr)));
        System.out.println(Arrays.toString(maketwoarr(arr)));
    }
//将一个序列，拆分成两个序列
    public  static  int[] mergeSort(int[] arr){
        if(arr.length<=1) return arr;
        int num = arr.length>>1;
        int[] leftarr = Arrays.copyOfRange(arr,0,num);
        int[] rightarr= Arrays.copyOfRange(arr,num,arr.length);
        return mergeTwoArray(mergeSort(leftarr),mergeSort(rightarr));
    }

    //将两个排好序列的短序列合并为一个序列
    public  static  int[] mergeTwoArray(int[] arr1,int[] arr2){
     int i =0;int j =0;int k=0;
     int[] result = new int[arr1.length+arr2.length];
     while (i< arr1.length&&j<arr2.length){
         if(arr1[i]<=arr2[j]){
             result[k++]= arr1[i++];
         }else {
             result[k++]=arr2[j++];
         }
     }
     while (i<arr1.length){
         result[k++] = arr1[i++];
     }
        while (j<arr2.length){
            result[k++] = arr2[j++];
        }
       return result;
    }

//归并

//拆分
    public static  int[] maketwoarr(int[] arr){
        if(arr.length<=1) return arr;
        int num = arr.length>>1;
        int[] arr1 = Arrays.copyOfRange(arr,0,num);
        int[] arr2 = Arrays.copyOfRange(arr,num,arr.length);
        return  addsort(maketwoarr(arr1),maketwoarr(arr2));
    }

    public  static  int[] addsort(int[] arr1,int[] arr2){
        int i=0 ,j=0,k=0;
        int[] res = new int[arr1.length+arr2.length];
        while (i<arr1.length&&j<arr2.length){
            if(arr1[i]<=arr2[j]){
                res[k++] = arr1[i++];
            }else {
                res[k++] = arr2[j++];
            }
        }

        while (i<arr1.length){
            res[k++] = arr1[i++];
        }
        while (j<arr2.length){
            res[k++] = arr2[j++];
        }
        return  res;
    }
}


