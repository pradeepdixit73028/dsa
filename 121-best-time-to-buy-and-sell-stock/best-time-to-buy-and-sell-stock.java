class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int ans=0;
        for(int p:prices){
            min=Math.min(min,p);
            ans=Math.max(ans,p-min);
        }
        return ans;
    }
}