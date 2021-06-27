import java.util.Arrays;

public class Mysort {

    //选择排序接口
    public  int[] chooseSort(int[] arr){
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
    public    int[] insertSort(int[] arr){
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
    //快速排序
    public    int[] quickSort(int[] arr,int low,int high){
        if(low>high) return  arr;
        if(arr==null||arr.length==0) return arr;
        int left = low;
        int rigth = high;
        int temp = arr[left];
        while (left<rigth){
            while (left<rigth&&temp<=arr[rigth]){
                rigth--;
            }
            arr[left] = arr[rigth];

            while (left<rigth&&temp>=arr[left]){
                left++;
            }
            arr[rigth] = arr[left];
        }

        arr[left] = temp;

        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);
        return arr;
    }

    //希儿排序
    public   int[] shellSort(int[] arr){
        if(arr.length==0||arr==null) return arr;
        int gp = arr.length>>1;
        for(;gp>0;gp/=2){
            for(int i = 0;i<arr.length;i=i+gp){
                for(int j = 0;j+gp <arr.length;j=j+gp){
                    if(arr[j]>arr[j+gp]){
                        int temp = arr[j];
                        arr[j] = arr[j+gp];
                        arr[j+gp] = temp;
                    }
                }
            }
        }
        return  arr;
    }

    //归并排序

    public   int[] getTwoarr(int[] arr){
        if(arr.length<=1) return arr;
        int num = arr.length/2;
        int[] arr1 = Arrays.copyOfRange(arr,0,num);
        int[] arr2 = Arrays.copyOfRange(arr,num,arr.length);
        return addSort(getTwoarr(arr1),getTwoarr(arr2));
    }

    public int[]  addSort(int[] arr1,int[] arr2){
        int i=0,j=0,k=0;
        int[] res = new int[arr1.length+arr2.length];

        while (i<arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                 res[k++] = arr1[i++];
            }else{
                res[k++] =arr2[j++];
            }
        }

        while (i<arr1.length){
            res[k++] = arr1[i++];
        }


        while (j<arr2.length){
            res[k++] = arr2[j++];
        }
        return res;
    }

    //冒泡

    public   int[] paoSort(int[] arr){
        int len = arr.length;
        if(len==0||arr==null) return arr;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i]  = arr[j];
                    arr[j]  = temp;
                }
            }
        }
        return arr;
    }
 }
