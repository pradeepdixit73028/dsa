class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        if(n==3) return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int prev_1=nums[0],prev_2=Math.max(nums[0],nums[1]),curr1=0;
        int p_1=nums[1],p_2=Math.max(nums[1],nums[2]),curr2=0;
        for(int i=2;i<n;i++){
            if(i>=3){
                curr2=Math.max(p_2,nums[i]+p_1);
                p_1=p_2;
                p_2=curr2;
            }
            if(i<n-1){
                curr1=Math.max(prev_2,nums[i]+prev_1);
                prev_1=prev_2;
                prev_2=curr1;
            }
        }
        return Math.max(curr1,curr2);       
    }
}