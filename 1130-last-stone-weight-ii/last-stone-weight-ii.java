class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int stone : stones) sum += stone;
        Integer[][] dp= new Integer[stones.length][sum];
        return helper(stones, 0, 0, 0, dp);
    }
    private int helper(int[] stones,int i,int sumL,int sumR,Integer[][] dp) {
        if(i == stones.length){
            return Math.abs(sumL - sumR);
        }
        if(dp[i][sumL] != null) {
            return dp[i][sumL];
        }
        dp[i][sumL] = Math.min(helper(stones, i+1, sumL + stones[i], sumR, dp) , helper(stones, i+1, sumL, sumR + stones[i], dp));
        return dp[i][sumL];
    }
}