class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                int temp=0;
                temp=n-Math.abs(nums[i])%n+i;
                result[i]=nums[temp%n];
            }
            else if(nums[i]==0){
                result[i]=nums[i];
            }
            else{
                result[i]=nums[(nums[i]%n+i)%n];
            }
        }
        return result;
    }
}