class Solution{
    public int countNumbersWithUniqueDigits(int n){
        int x=(int)Math.pow(10,n);
        String a=String.valueOf(x);
        int ans=numDupDigitsAtMostN(x-1);
        return x-ans;
    }
    Integer[][][][][] dp;
    static final int len=11;
    static final int masklen=1024;
    public int numDupDigitsAtMostN(int n){
        String a=String.valueOf(n);
        dp=new Integer[len][2][2][masklen][2];
        int ans=solve(a,0,1,0,0,1);
        return ans;
    }
    public int solve(String s,int idx,int tight,int repeated,int mask,int lz){
        if(idx==s.length()) return repeated;
        if(dp[idx][tight][repeated][mask][lz]!=null) return dp[idx][tight][repeated][mask][lz];
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int new_tight=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0) res +=solve(s,idx+1,new_tight,repeated,mask,lz);
            else{
                int used=1 & (mask>>digit);
                int new_repeated=(repeated==1||used==1) ? 1:0;
                int new_mask=(1<<digit) | mask;
                res += solve(s,idx+1,new_tight,new_repeated,new_mask,0);
            }
        }
        return dp[idx][tight][repeated][mask][lz]=res;
    }
}