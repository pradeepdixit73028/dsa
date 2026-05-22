class Solution {
    public int search(int[] nums, int t) {
        int n=nums.length;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mi=l+(r-l)/2;
            if(nums[mi]==t) return mi;
            if(nums[l]<=nums[mi]){
                if(t>=nums[l] && t<nums[mi]){
                    r=mi-1;
                }else{
                    l=mi+1;
                }
            }else{
                if(t>nums[mi] && t<=nums[r]){
                   l=mi+1; 
                }else{
                    r=mi-1;
                }
            }
        }
        return -1;
    }
}