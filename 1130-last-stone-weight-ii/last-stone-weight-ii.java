class Solution {
    private int solve(int[] arr,int n,int sum,Integer dp[][])
    {
        if(n==0)
            return 0;
        if(sum<=0)
            return 0;
        if(dp[n][sum]!=null)
            return dp[n][sum];
        if(arr[n-1]<=sum)
            return dp[n][sum]=Math.max(arr[n-1]+solve(arr,n-1,sum-arr[n-1],dp),
                                     solve(arr,n-1,sum,dp));
        else
            return dp[n][sum]=solve(arr,n-1,sum,dp);
    }
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=stones[i];
        int half=sum/2;
        Integer dp[][]= new Integer[n+1][half+1];
        int p1=solve(stones,n,half,dp);
        int p2=sum-p1;
        return Math.abs(p1-p2);
    }
}