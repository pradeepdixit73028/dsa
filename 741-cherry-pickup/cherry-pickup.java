class Solution {
    Integer[][][][] dp;
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        dp=new Integer[n+1][n+1][n+1][n+1];
        int res=helper(0,0,0,0,n,grid);
        return Math.max(0,res);        
    }
    public int helper(int r1,int c1,int r2,int c2,int n,int[][] grid){
        if(r1>=n || c1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }

        if(dp[r1][c1][r2][c2]!=null) return dp[r1][c1][r2][c2];

        if(r1==n-1 && c1==n-1 && r2==n-1 && c2==n-1){
            return grid[r1][c1];
        }

        int cherries=(r1==r2 && c1==c2) ? grid[r1][c1]:grid[r1][c1]+ grid[r2][c2];

        int ans=Integer.MIN_VALUE;

        ans=Math.max(ans,helper(r1+1,c1,r2+1,c2,n,grid));
        ans=Math.max(ans,helper(r1,c1+1,r2,c2+1,n,grid));
        ans=Math.max(ans,helper(r1+1,c1,r2,c2+1,n,grid));
        ans=Math.max(ans,helper(r1,c1+1,r2+1,c2,n,grid));
        return dp[r1][c1][r2][c2]=ans+cherries;
    }
}