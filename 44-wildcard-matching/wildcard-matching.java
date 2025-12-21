class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        Boolean[][] dp=new Boolean[m+1][n+1];
        return solve(m,n,s,p,dp); 
    }
    boolean solve(int i,int j,String s, String t,Boolean[][] dp){
        if(j==0) return (i==0);
        if(i==0){
            for(int k=j;k>0;k--){
                if(t.charAt(k-1)!='*') return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        char ch=t.charAt(j-1);
        if(s.charAt(i-1)==ch || ch=='?') dp[i][j]=solve(i-1,j-1,s,t,dp);
        else if(ch=='*') dp[i][j] =(solve(i-1,j,s,t,dp)||solve(i,j-1,s,t,dp));
        else dp[i][j]=false;
        return dp[i][j];
    }
}