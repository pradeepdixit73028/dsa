class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        Integer [][]dp= new Integer[n][amount+1];
        dp[0][0]=0;
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[0][i]=i/coins[0];
            }
            else dp[0][i]=(int)1e9;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notpick=dp[i-1][j];
                int pick=(int)1e9;
                if(coins[i]<=j){
                    pick = 1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(pick,notpick);
            }
        }
        int ans = dp[n-1][amount];
        return(ans>=(int)1e9)? -1:ans;
    }
}