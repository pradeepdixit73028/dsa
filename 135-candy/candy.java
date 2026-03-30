class Solution {
    public int candy(int[] rating) {
        int n=rating.length;
        int[] candy=new int[n];
        Arrays.fill(candy,1);
        for(int i=1;i<n;i++){
            if(rating[i]>rating[i-1])
                candy[i]=candy[i-1]+1;
        }
        for(int i=n-2;i>=0;i--){
            if(rating[i]>rating[i+1]) candy[i]=Math.max(candy[i],candy[i+1]+1);
            
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=candy[i];
        }
        return ans;
    }
}