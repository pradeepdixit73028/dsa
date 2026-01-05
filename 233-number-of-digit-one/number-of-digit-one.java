class Solution {
    public int countDigitOne(int n) {
        String a=String.valueOf(n);
        Integer[][][] dp=new Integer[11][2][10];
        return solve(a,0,1,0,dp);
    }
    int solve(String s,int idx,int tight,int count,Integer[][][] dp){
        if(idx==s.length()) return count;
        if(dp[idx][tight][count]!=null) return dp[idx][tight][count];
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int new_tight=(tight==1 && digit==ub) ? 1:0;
            if(digit==1) res += solve(s,idx+1,new_tight,count+1,dp);
            else res += solve(s,idx+1,new_tight,count,dp);
        }
        return dp[idx][tight][count]=res;
    } 
}