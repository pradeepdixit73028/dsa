class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n && nums[i]<0){
            i++;
        }
        int j=i-1;
        for(int idx=0;idx<n;idx++){
            nums[idx]=nums[idx]*nums[idx];
        }
        int[] ans=new int[n];
        int idx=0;
        while(j>=0 && i<n){
            if(nums[j]<nums[i]){
                ans[idx++]=nums[j];
                j--;
            }else{
                ans[idx++]=nums[i];
                i++;
            }
        }
        while(j>=0){
            ans[idx++]=nums[j];
            j--;
        }
        while(i<n){
            ans[idx++]=nums[i];
            i++;
        }
        return ans;


    }
}