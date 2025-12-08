class Solution {
    int m;
    int n;
    public int calculateMinimumHP(int[][] dungeon) {
        m=dungeon.length;
        n=dungeon[0].length;
        Integer [][]dp = new Integer[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = Integer.MAX_VALUE/4;
            }
        }
        dp[m][n-1]=1;
        dp[m-1][n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int need = Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j];
                dp[i][j]=Math.max(1,need);
            }
        }
        return dp[0][0];
    }
}