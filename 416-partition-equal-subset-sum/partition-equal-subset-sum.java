class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum = 0;
        for(int num:nums){
            sum +=num;
        }
        if(sum%2==1){
            return false;
        }
        int target = sum/2;
        Boolean [][]dp= new Boolean[n][target+1];
        return solve(n-1,nums,target,dp);
    }
    public boolean solve(int i,int[] nums,int target,Boolean [][]dp){
        if(target==0) return true;
        if(i==0)  return nums[0]==target;
        if(dp[i][target]!=null) return dp[i][target];
        boolean notpick = solve(i-1,nums,target,dp);
        boolean take =false;
        if(nums[i]<=target){
            take= solve(i-1,nums,target-nums[i],dp);
        }
        return dp[i][target]=(notpick || take);
    }
}