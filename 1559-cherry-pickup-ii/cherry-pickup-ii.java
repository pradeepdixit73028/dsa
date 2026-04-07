class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        dp=new Integer[n+1][m+1][m+1];
        return helper(0,0,m-1,grid);
    }
    public int helper(int r,int c1,int c2,int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
        if(c1<0||c2<0||c1>m-1||c2>m-1){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c1][c2]!=null) return dp[r][c1][c2];
        if(r==n-1){
            if(c1==c2) return grid[r][c1];
            return grid[r][c1]+grid[r][c2];
        } 
        int curr;
        if(c1==c2) curr=grid[r][c1];
        else curr=grid[r][c1]+grid[r][c2];

        int ans=0;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                ans=Math.max(ans,helper(r+1,c1+d1,c2+d2,grid));
            }
        }
        return dp[r][c1][c2]=curr+ans;
    }
}