class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return count(nums,target,0,0);      
    }
    public int count(int nums[],int target,int sum,int i){
        if(i==nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        int include = count(nums,target,sum+nums[i],i+1);
        int exclude = count(nums,target,sum - nums[i],i+1);
        return  (include + exclude);
    }
}