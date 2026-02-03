class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degreein=new int[n+1];
        int[] degreeout=new int[n+1];
        for(int[] edge:trust){
            degreein[edge[1]]++;
            degreeout[edge[0]]++;
        }
        for(int i=1;i<=n;i++){
            if(degreein[i]==n-1&&degreeout[i]==0){
                return i;
            }
        }
        return -1;
    }
}