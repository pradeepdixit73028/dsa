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
        boolean [][]dp = new boolean[n][target+1];
        dp[0][0]=true;
        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=target;j++){
                boolean notpick=dp[i-1][j];
                boolean pick=false;
                if(nums[i]<=j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j]=(pick || notpick);
            }
        }
        return dp[n-1][target];
    }
}