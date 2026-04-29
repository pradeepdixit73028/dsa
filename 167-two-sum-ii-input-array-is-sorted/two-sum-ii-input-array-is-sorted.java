class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0;i<n-1;i++){
            int search=target-numbers[i];
            int ans=binarysearch(numbers,search,i+1,n-1);
            if(ans!=-1) return new int[]{i+1,ans+1};
        }
        return new int[]{-1,-1};
    }
    int binarysearch(int[] arr,int t,int low,int high){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==t) return mid;
            else if(arr[mid]>t) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}