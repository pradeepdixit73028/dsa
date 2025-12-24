class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;
        int[][] dp=new int[n][1001];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],1);
        }
        int max=1;
        for(int curr=1;curr<n;curr++){
            for(int prev=0;prev<curr;prev++){
                int diff=nums[curr]-nums[prev];
                int diffidx=diff+500;
                if(dp[curr][diffidx]<dp[prev][diffidx]+1){
                    dp[curr][diffidx]=dp[prev][diffidx]+1;
                    max=Math.max(max,dp[curr][diffidx]);
                }
            }
        }
        return max;
    }
}