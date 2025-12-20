class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        Integer[][] dp= new Integer[m][n];
        return solve(word1,word2, m-1,n-1,dp);
    }
    private int solve(String w1,String w2,int i,int j,Integer[][] dp){
        if(i<0) return j+1; 
        if(j<0) return i+1; 
        if(dp[i][j]!=null) return dp[i][j];
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j]=solve(w1,w2,i-1,j-1,dp);
        }else{
            int insert = solve(w1,w2,i,j-1,dp);
            int delete = solve(w1,w2,i-1,j,dp);
            int replace = solve(w1,w2,i-1,j-1,dp);
            return dp[i][j]=1+Math.min(replace,Math.min(insert, delete));
        }
    }
}