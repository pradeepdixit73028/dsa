class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ret=0;
        int count=0;
        for(int num: nums){
            if(num==1){
                count++;
                ret=Math.max(count,ret);
            }else{
                count=0;
            }
        }
        return ret;
    }
}