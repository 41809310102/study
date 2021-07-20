public class Demo {
    //输入无序正整数，输出数组中没有出现的最小正整数，O（n）
    public static void main(String[] args) {
        int[] arr = {1,2,5,4};
        System.out.println(mySub(arr));
    }

    public static   int   mySub(int[] arr){
        if(arr==null||arr.length==0) return -1;

        //
        int max = arr[0];

        for(int i = 0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }

        int[] num = new int[max+1];
        for(int i = 0;i<max+1;i++){
            num[i] = 0;
        }

        for(int i = 0;i<arr.length;i++){
              num[arr[i]-1] = 1;
        }

        for(int i = 1;i<=max+1;i++){
            if(num[i]==0){
             return i+1;
            }
        }
        return  -1;
    }
}
