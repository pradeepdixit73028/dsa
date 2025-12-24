class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int max=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num<=max){
                max=num;
            }else if(num<=min){
                min=num;
            }else{
                return true;
            }
        }
        return false;
    }
}