class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        Integer [][]dp= new Integer[n][n];
        return solve(0,0,n,triangle,dp);
    }
    public int solve(int i,int j,int n,List<List<Integer>> t,Integer [][]dp){
        if(i==n-1) return t.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];
        int down = t.get(i).get(j)+solve(i+1,j,n,t,dp);
        int diagonal = t.get(i).get(j)+solve(i+1,j+1,n,t,dp);
        dp[i][j] = Math.min(down,diagonal);
        return dp[i][j]; 
    }
}