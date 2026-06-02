import java.util.*;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx=i;
                break;
            }
        }
        if(idx==-1){
            reverse(nums,0,n-1);
            return;
        }
        reverse(nums,idx+1,n-1);
        int j=-1;
        for(int i=idx+1;i<n;i++){
            if(nums[idx]<nums[i]){
                j=i;
                break;
            }
        }
        swap(nums,idx,j);
    }
    private void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
