class Solution {
    public int findTargetSumWays(int[] a, int target) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) sum += a[i];
        Integer[][] dp = new Integer[a.length][(2*sum)+1];
        return helper(a,a.length - 1,0,target,dp,sum);
    }
    public static int helper(int[] a,int index,int sum,int target,Integer[][] dp,int total){
        if(index < 0){
            if(target == sum){
                return 1;
            }else{
                return 0;
            }
        }
        int sumIndex = sum+total;
        if(dp[index][sumIndex] != null){
            if(dp[index][sumIndex] != 0)
                return dp[index][sumIndex];
            else return 0;
        }
        int plus = helper(a,index-1,sum + a[index],target,dp,total);
        int minus = helper(a,index-1,sum - a[index],target,dp,total);
        dp[index][sumIndex] = plus+minus;
        return dp[index][sumIndex];
    }
}