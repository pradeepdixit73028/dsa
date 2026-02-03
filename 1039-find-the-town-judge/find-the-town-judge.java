class Solution {
    public int findJudge(int n, int[][] trust){
        if(n==1&&trust.length==0) return 1;
        int[] degree=new int[n+1];
        for(int[] edge:trust){
            int a=edge[0],b=edge[1];
            degree[a]--;
            degree[b]++;
        }
        for(int i=1;i<=n;i++){
            if(degree[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}