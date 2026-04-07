class Solution {
    int m,n,target;
    int INF=(int)1e9;
    int[] house;
    int[][] cost;
    Integer[][][] dp;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m=m;
        this.n=n;
        this.target=target;
        this.house=houses;
        this.cost=cost;
        dp=new Integer[m][n+1][target+1];
        int ans=helper(0,0,0);
        if(ans==INF){
            return -1;
        }
        return ans;

    }
    public int helper(int i,int pre,int neigh){
        if(i==m){
            if(neigh==target) return 0;
            return INF;
        }
        if(neigh>target) return INF;
        if(dp[i][pre][neigh]!=null) return dp[i][pre][neigh];
        if(house[i]!=0){
            int color=house[i];
            int newn=neigh+(color!=pre ? 1:0);
            return helper(i+1,color,newn);

        }
        int ans=INF;
        for(int j=1;j<=n;j++){
            int newn=neigh+(j != pre ? 1:0);
            ans=Math.min(ans,cost[i][j-1]+helper(i+1,j,newn));
        }
        return dp[i][pre][neigh]=ans;
    }
}