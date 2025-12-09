class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        Integer [][]dp= new Integer[n][amount+1];
        int ans = solve(n-1,amount,coins,dp);
        return(ans>=(int)1e9)? -1:ans;
    }
    public int solve(int i,int amount,int[] coins,Integer [][]dp){
        if(amount==0) return 0;
        if(i==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int)1e9;
        }
        if(dp[i][amount]!=null) return dp[i][amount];
        int nottake = solve(i-1,amount,coins,dp);
        int take = (int)1e9;
        if(coins[i]<=amount){
            take = 1 + solve(i,amount-coins[i],coins,dp);
        }
        return dp[i][amount]=Math.min(nottake,take);
    }
}