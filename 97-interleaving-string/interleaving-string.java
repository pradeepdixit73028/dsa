class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if((n1+n2)!=n3) return false;
        Boolean[][] dp= new Boolean[n1+1][n2+1];
        return solve(n1,n2,n3,s1,s2,s3,dp);
    }
    boolean solve(int i,int j,int k,String s1, String s2, String s3,Boolean[][] dp){
        if(k==0) return true;
        if(dp[i][j]!=null) return dp[i][j];
        boolean take1=false;
        boolean take2=false;
        if(i>0 && s1.charAt(i-1)==s3.charAt(k-1))  take1=solve(i-1,j,k-1,s1,s2,s3,dp);
        if(j>0 && s2.charAt(j-1)==s3.charAt(k-1))  take2=solve(i,j-1,k-1,s1,s2,s3,dp);
        dp[i][j]=take1||take2;
        return dp[i][j];
    }
}