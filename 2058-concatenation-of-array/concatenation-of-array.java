class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] newnum=new int[2*n];
        for(int i=0;i<n;i++){
            newnum[i]=nums[i];
            newnum[n+i]=nums[i];
        }
        return newnum;
    }
}