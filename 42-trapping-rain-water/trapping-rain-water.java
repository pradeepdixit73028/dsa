class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int ans=0;
        int left_max=Integer.MIN_VALUE;
        int right_max=Integer.MIN_VALUE;
        int left=0;
        int right=n-1;
        while(left<right){
            if(height[left]<height[right]){
                if(left_max<=height[left]) left_max=height[left];
                else ans+=left_max-height[left];
                left++;

            }else{
                if(right_max<=height[right]) right_max=height[right];
                else ans+=right_max-height[right];
                right--;
            }
        }
        return ans;
    }
}