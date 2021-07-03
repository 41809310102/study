public class Solution {
    public int InversePairs(int [] array) {
        return merge(array,0,array.length-1);
    }

    public int merge(int[] nums,int start,int end){
        if(start>=end) return 0;
        int mid = (start+end)/2;
        int count=0;
        count+=merge(nums,start,mid);
        count+=merge(nums,mid+1,end);
        int p = 0;
        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        while(i<=mid&&j<=end){
            if(nums[i]<nums[j]){
                temp[p++] = nums[i++];
            }else{
                count=(count+(mid-i+1))%1000000007;
                temp[p++] = nums[j++];
            }
        }
        if(i <= mid){
            while(i <= mid){
                temp[p++] = nums[i++];
            }
        }
        if(j <= end){
            while(j <= end){
                temp[p++] = nums[j++];
            }
        }
        for(int k = 0;k < end-start+1; k++){//将合并好的数组再复制回nums，以保证有序。
            nums[start+k] = temp[k];
        }
        return count;

    }
}

