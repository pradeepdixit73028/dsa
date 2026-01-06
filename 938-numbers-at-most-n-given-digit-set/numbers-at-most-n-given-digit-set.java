class Solution {
    Integer[][][] dp;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s=String.valueOf(n);
        int mask=0;
        for(int i=0;i<digits.length;i++){
            int digit=Integer.parseInt(digits[i]);
            mask=mask|(1<<digit);
        }
        dp=new Integer[s.length()][2][2];
        int ans=solve(s,0,1,mask,1)-1;
        return ans;
    }
    public int solve(String s,int idx,int tight,int mask,int lz){
        if(idx==s.length()) return 1;
        if(dp[idx][tight][lz]!=null ) return dp[idx][tight][lz];
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int new_tight=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0) res +=solve(s,idx+1,new_tight,mask,lz);
            int used=1&(mask>>digit);
            if(used==0) continue;
            else{
                res += solve(s,idx+1,new_tight,mask,0);
            }
        }
        return dp[idx][tight][lz]=res;
    }
}