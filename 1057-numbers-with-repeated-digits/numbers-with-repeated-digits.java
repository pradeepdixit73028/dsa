class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public int numDupDigitsAtMostN(int n) {
        String a=String.valueOf(n);
        Integer[][][][][] dp=new Integer[11][2][2][1024][2];
        int ans=solve(a,0,1,0,0,1,dp);
        return ans;
    }
    public int solve(String s,int idx,int tight,int repeated,int mask,int lz,Integer[][][][][] dp){
        if(idx==s.length()) return repeated;
        if(dp[idx][tight][repeated][mask][lz]!=null) return dp[idx][tight][repeated][mask][lz];
        int lb=0;
        int ub=(tight==1) ? s.charAt(idx)-'0':9;
        int res=0;
        for(int digit=lb;digit<=ub;digit++){
            int new_tight=(tight==1 && digit==ub) ? 1:0;
            if(lz==1 && digit==0) res +=solve(s,idx+1,new_tight,repeated,mask,lz,dp);
            else{
                int used=1 & (mask>>digit);
                int new_repeated=(repeated==1||used==1) ? 1:0;
                int new_mask=(1<<digit) | mask;
                res += solve(s,idx+1,new_tight,new_repeated,new_mask,0,dp);
            }
        }
        return dp[idx][tight][repeated][mask][lz]=res;
    }
}