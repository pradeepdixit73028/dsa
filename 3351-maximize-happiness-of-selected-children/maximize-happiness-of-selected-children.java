class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n=happiness.length;
        Arrays.sort(happiness);
        if(k>n) return 0;
        int sub=0;
        int take=n-1;
        long ans=0;
        for(int i=0;i<k;i++){
            long add=happiness[take]-sub;
            if(add<0) add=0;
            ans+=add;
            take--;
            sub++;
        }
        return ans;
    }
}