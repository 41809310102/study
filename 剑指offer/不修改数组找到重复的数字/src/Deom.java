public class Deom {
    //不修改数组找到重复的数字
    public static void main(String[] args) {
        int[] nums = {2,3,5,4,3,2,6,7};
            Deom sb = new Deom();
            System.out.println(sb.Found(nums));
            System.out.println(sb.getNumber(nums));
    }
    //辅助空间
    private  int  Found(int[] nums){
        int[] arr = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        for (int j=0;j<nums.length;j++){
            for(int k=0;k<arr.length;k++){
                if(nums[j]==arr[k]){
                    return nums[j];
                }
            }
        }
        return -1;
    }
    private int getNumber(int[] arr){
        if (arr==null||arr.length<=0) return -1;
        int left =0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (right-left)/2+left;
            int count=countNumber(arr,left,mid);
            if(left==right){
                if(count>1)
                    return left;
                else
                    break;
            }
            if(count>(mid-left+1)){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }
    public int countNumber(int[] arr,int left,int right){
        if (arr==null){
            return 0;
        }
        int count=0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>=left&&arr[i]<=right){
                ++count;
            }
        }
        return count;
    }
}
