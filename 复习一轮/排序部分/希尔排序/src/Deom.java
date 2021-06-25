import java.util.Arrays;

/**
 * 希尔排序
 *
 * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（一般初次取数组半长，之后每次再减半，直到增量为1）
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @param
 */

public class Deom {
    public static void main(String[] args) {
        int[] arr = {2,1,6,9,5,4,20,19,11};
          //shellSort(arr);
          //shellsort(arr);
         // insort(arr);
         // quickSort(arr,0,arr.length-1);
        //shellsort1(arr);
       // System.out.println(Arrays.toString(getTwoarr(arr)));
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
//希儿排序
    public  static  void shellsort(int[] arr){
        if(arr.length==0||arr==null) return;
        int group = arr.length>>1;
        for(;group>0;group=group>>1){
            for(int i = 0;i+group<arr.length;i++){
                for(int j = 0;j+group<arr.length;j=j+group){
                    if(arr[j]>arr[j+group]){
                        int temp = arr[j];
                        arr[j] = arr[j+group];
                        arr[j+group] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
//选择排序
    public  static  void chosesort(int[] arr){
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

    //插入排序
    public  static  void  insort(int[] arr){
        if(arr.length==0||arr==null) return;

        for(int i = 0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
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
//快排
    public  static   void  quickSort(int[] arr,int low,int high){
        if(arr==null||arr.length==0) return;
        if(low>high) return;
        int left = low;
        int right =high;
        int temp = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=temp){
                right--;
            }
            arr[left] = arr[right];

            while (left<right&&arr[left]<=temp){
                left++;
            }
            arr[right] = arr[left];


        }
        arr[left] = temp;
        quickSort(arr,low,left-1);
        quickSort(arr,left+1,high);

        System.out.println(Arrays.toString(arr));
    }

    //归并
    public  static  int[] getTwoarr(int[] arr){
        if(arr.length<=1) return arr;
        int num = arr.length>>1;
        int[] arr1 = Arrays.copyOfRange(arr,0,num);
        int[] arr2 = Arrays.copyOfRange(arr,num,arr.length);
        return addSort(getTwoarr(arr1),getTwoarr(arr2));
    }

    public static int[] addSort(int[] arr1,int[] arr2){
        int i=0,j=0,k=0;
        int[] res = new int[arr1.length+arr2.length];
        while (i< arr1.length&&j<arr2.length){
            if(arr1[i]<arr2[j]){
                res[k++] = arr1[i++];
            }else{
                res[k++] = arr2[j++];
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
    //希儿

    public  static  void shellsort1(int[] arr){
        if(arr==null||arr.length==0) return;

        int gp = arr.length>>1;
        for(;gp>0;gp=gp>>1){
            for(int i = 0;i+gp <arr.length;i++){
                for(int j = 0;j+gp <arr.length;j=j+gp){
                    if(arr[j]>arr[j+gp]){
                        int temp = arr[j];
                        arr[j] = arr[j+gp];
                        arr[j+gp] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
 }
