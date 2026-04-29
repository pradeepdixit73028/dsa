class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++){
            high+=weights[i];
            low=Math.max(low,weights[i]);
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,mid,days)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public boolean isPossible(int[] arr,int mid,int days){
        int n=arr.length;
        int load=0;
        int time=1;
        for(int i=0;i<n;i++){
            load+=arr[i];
            if(load>mid){
                time++;
                load=arr[i];
            }
        }
        return time<=days;
    }
}