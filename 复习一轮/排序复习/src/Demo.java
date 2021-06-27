import java.util.Arrays;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        Mysort mysort = new Mysort();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }


            System.out.println("++++++++++++++++++++");
            System.out.println("   1.冒泡排序");
            System.out.println("   2.插入排序");
            System.out.println("   3.选择排序");
            System.out.println("   4.快速排序");
            System.out.println("   5.归并排序");
            System.out.println("   6.希尔排序");
            System.out.println("++++++++++++++++++++");
            System.out.println("输入需要的排序方法");
            int res = sc.nextInt();
            switch (res) {
                case 1:
                   int[] newarr1 = mysort.paoSort(arr);
                    System.out.println(Arrays.toString(newarr1));break;
                case 2:
                    int[] newarr2 = mysort.insertSort(arr);
                    System.out.println(Arrays.toString(newarr2));break;
                case 3:
                    int[] newarr3 =mysort.chooseSort(arr);
                    System.out.println(Arrays.toString(newarr3));break;
                case 4:
                    int[] newarr4 = mysort.quickSort(arr,0,arr.length-1);
                    System.out.println(Arrays.toString(newarr4));break;
                case 5:
                    int[] newarr5 = mysort.getTwoarr(arr);
                    System.out.println(Arrays.toString(newarr5));break;
                case 6:
                    int[] newarr6 =mysort.shellSort(arr);
                    System.out.println(Arrays.toString(newarr6));break;
                default:
                    System.out.println("操作错误！");
                    return;
            }

        }
    }
}
