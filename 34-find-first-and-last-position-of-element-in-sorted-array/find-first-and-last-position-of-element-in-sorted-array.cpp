class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int lo=0,hi=nums.size()-1;
        int a=0,b=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(target==nums[mid]){
                int x=mid;
                while(lo<=mid){
                    int m=lo+(mid-lo)/2;
                    if(nums[m]==target) mid=m-1;
                    else lo=m+1;
                }
                while(x<=hi){
                    int m=x+(hi-x)/2;
                    if(nums[m]==target) x=m+1;
                    else hi=m-1;
                }
                return {lo,hi};
            }
            else if(target<nums[mid]) hi=mid-1;
            else lo=mid+1;
        }
        return {-1,-1};
    }
};