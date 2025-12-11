class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result =nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int l=i+1,r=n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(target-result)) {
                    result=sum;
                }
                if(sum==target) return target;
                else if(sum<target) l++;
                else r--;
            }
        }
        return result;
    }
}