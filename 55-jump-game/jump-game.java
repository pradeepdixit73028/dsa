// -----------------------------------------------------------
// 2. Memoization (Top-Down DP)
// -----------------------------------------------------------
class Solution {
    boolean solve(int nums[], int i, int dp[]) {
        if(i >= nums.length-1) return true;
        if (dp[i] != -1) return dp[i] == 1;

        for(int step = 1; step <= nums[i]; step++) {
            if(solve(nums, i+step, dp)) {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, 0, dp);
    }
}