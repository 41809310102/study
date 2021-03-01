public class Deom {
    //数组中重复的数字
    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        Deom sb = new Deom();
        //System.out.println(sb.Found1(nums));
        System.out.println(sb.Found3(nums));
    }
    private  int  Found1(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int res;
                if(nums[i]>nums[j]){
                    res = nums[i];
                    nums[i]=nums[j];
                    nums[j]=res;
                }
            }
        }
        int n=0;
        while (n<nums.length){
            for( n =0;n<nums.length;n++){
            if(nums[n]==nums[n+1]){
                return  nums[n];
            }
            n++;
           }
        }
        return 0;
    }

    private  int Found2(int[] nums){
        int[] res = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            int j;
            for(j=0;j<res.length;j++){
                if(nums[i]!=res[j]){
                    res[j]=nums[i];
                    i++;
                    j++;
                }
                else if(nums[i]==res[j]){
                    return nums[i];
                }
                }
            }
        return -1;
        }

        private  boolean Found3(int[] nums){
        if(nums==null||nums.length==0) return false;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<0||(nums[i]>nums.length-1)){
                return  false;
            }
        }
        for(int i =0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return true;
                }
                int tmp ;
                tmp = nums[i];
                nums[i]=nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return false;
        }
    }


