class Solution {
    public int findNumberOfLIS(int[] nums){
       int n = nums.length;
       int dp[] = new int [n];
       int count [] = new int [n];
       Arrays.fill(dp,1);
       Arrays.fill(count,1);
       int max = 1;
       for(int cur=1;cur<n;cur++){
        for(int pre=0;pre<cur;pre++){
            if(nums[cur]>nums[pre] && dp[cur]<dp[pre]+1){
                dp[cur]=dp[pre]+1;
                count[cur]=count[pre];
                max=Math.max(max,dp[cur]);
            }
            else if(nums[cur]>nums[pre] && dp[cur]==dp[pre]+1){
                count[cur]=count[cur]+count[pre];
            }
        }
       }
       int ans = 0;
       for(int i =0;i<n;i++){
        if(dp[i] == max){
            ans = ans + count[i];
        }
       }
       return ans;
    }
}