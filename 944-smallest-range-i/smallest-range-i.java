class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        
        
        return (min+k)>(max-k)?0:(max-k)-(min+k);
        
    }
}