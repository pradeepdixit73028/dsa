class Solution {
    public int minEatingSpeed(int[] arr,int h) {
        int n = arr.length;
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            high=Math.max(high,arr[i]);
        }

        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(arr,mid,h)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[] arr,int mid,int h){
        long time=0;
        for(int i=0;i<arr.length;i++){
            time+=(arr[i]+mid-1)/mid;
        }
        if(time>h) return false;
        return true;
    }
}