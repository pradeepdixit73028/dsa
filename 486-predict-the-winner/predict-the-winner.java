class Solution {
    public boolean predictTheWinner(int[] nums) {
        int s=0;
        int n= nums.length;
        return helper(nums,s,0,n-1)>=0;
    }
    public int helper(int[] nums,int i,int t,int j){
        if(i>j) return 0;
        int ans=0;
        if(t%2==0){
            int pleft= nums[i]+helper(nums,i+1,t+1,j);
            int pright= nums[j]+helper(nums,i,t+1,j-1);
            ans= Math.max(pleft,pright);
        }else{
            int pleft= -nums[i]+helper(nums,i+1,t+1,j);
            int pright= -nums[j]+helper(nums,i,t+1,j-1);
            ans= Math.min(pleft,pright);
        }
        return ans;
    }
}