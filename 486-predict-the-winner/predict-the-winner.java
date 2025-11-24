class Solution {
    public boolean predictTheWinner(int[] nums) {
        int s=0;
        int n= nums.length;
        return helper(nums,s,n-1)>=0;
    }
    public int helper(int[] nums,int i,int j){
        if(i>=j) return nums[i];
        int pleft= nums[i]-helper(nums,i+1,j);
        int pright= nums[j]-helper(nums,i,j-1);
        return Math.max(pleft,pright);
    }
}