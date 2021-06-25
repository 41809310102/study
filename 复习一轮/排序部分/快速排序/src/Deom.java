import java.util.Arrays;
import java.util.Stack;

/**
 * 用伪代码描述如下：
 *
 * ①. i = L; j = R; 将基准数挖出形成第一个坑a[i]。
 * ②．j--，由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
 * ③．i++，由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
 * ④．再重复执行②，③二步，直到i==j，将基准数填入a[i]中
 * ————————————————
 *
 */
public class Deom {
    public static void main(String[] args) {
        int[] arr = {25,89,56,88,21,3,56,66,8,663,55};
        int[] arr1 = {25,89,56,88,21,3,56,66,8,663,55};
     //   System.out.println("递归实现");
       // QuickSort(arr,0,arr.length-1);//以第一个数为基准、
        System.out.println("我的递归实现");
        quickSortme(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("非递归实现：");
        quickSortByStack(arr1);
    }
    public static void QuickSort(int[] arr ,int low,int high){
        if(arr==null||arr.length==0) return;
        if(low>=high) return;
        int left = low;
        int right = high;
        int temp = arr[left]; //确定基准值；
        while (left<right){
            while (left<right&&arr[right]>=temp){  //从后往前，找到小于或等于基准的数进行交换
                right--;
            }
            arr[left] = arr[right];

            while (left<right&&arr[left]<=temp){  //从前往后走，找到大于或等于基准的数进行交换
                left++;
            }
            arr[right] = arr[left];
        }
      arr[left]=temp; //将基准值填到坑3中
        //开始递归；
        QuickSort(arr,low,left-1);
        QuickSort(arr,left+1,high);
       // System.out.println(Arrays.toString(arr));
    }
    /**
     * 快速排序（非递归）
     *
     * ①. 从数列中挑出一个元素，称为"基准"（pivot）。
     * ②. 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     * ③. 把分区之后两个区间的边界（low和high）压入栈保存，并循环①、②步骤
     * @param arr   待排序数组
     */
    public static void quickSortByStack(int[] arr){
        if(arr.length <= 0) return;
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(arr.length - 1);
        while(!stack.isEmpty()){
            int high = stack.pop();     //出栈进行划分
            int low = stack.pop();
            int pivotIdx = QuickSort1(arr, low, high);
            //保存中间变量
            if(pivotIdx > low) {
                stack.push(low);
                stack.push(pivotIdx - 1);
            }
            if(pivotIdx < high && pivotIdx >= 0){
                stack.push(pivotIdx + 1);
                stack.push(high);
            }
        }
    }

    private static int QuickSort1(int[] arr, int low, int high){
        if(arr.length <= 0) return -1;
        if(low >= high) return -1;
        int l = low;
        int r = high;

        int pivot = arr[l];    //挖坑1：保存基准的值
        while(l < r){
            while(l < r && arr[r] >= pivot){  //坑2：从后向前找到比基准小的元素，插入到基准位置坑1中
                r--;
            }
            arr[l] = arr[r];
            while(l < r && arr[l] <= pivot){   //坑3：从前往后找到比基准大的元素，放到刚才挖的坑2中
                l++;
            }
            arr[r] = arr[l];
        }
        arr[l] = pivot;   //基准值填补到坑3中，准备分治递归快排
        System.out.println(Arrays.toString(arr));
        return l;
    }


    public static  void  quickSortme(int[] arr ,int low,int hight){
      if(low>hight) return;
      if(arr==null||arr.length==0) return;
      int left = low;
      int right = hight;
      int temp = arr[left];//找基准
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
        quickSortme(arr,low,left-1);
        quickSortme(arr,left+1,right);
    }
}
