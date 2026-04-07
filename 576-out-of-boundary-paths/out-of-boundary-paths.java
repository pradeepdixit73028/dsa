class Solution {
    int m,n;
    Integer[][][] dp;
    public int findPaths(int m, int n, int max, int s, int e) {
        this.m=m;
        this.n=n;
        dp=new Integer[m][n][max+1];
       return helper(s,e,max);
    }
    public int helper(int i,int j,int move){
        if(i<0||j<0||i>m-1||j>n-1){
            return 1;
        }
        if(move==0) return 0;
        if(dp[i][j][move]!=null) return dp[i][j][move];
        long left=helper(i-1,j,move-1);
        long right=helper(i+1,j,move-1);
        long up=helper(i,j-1,move-1);
        long down=helper(i,j+1,move-1);
        long ans=((long)left+right+up+down)%1000000007;
        return dp[i][j][move]=(int)ans;
    }
}