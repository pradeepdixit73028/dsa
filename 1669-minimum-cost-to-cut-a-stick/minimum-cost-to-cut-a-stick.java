class Solution {

    /*Recursion
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCut = new int[m+2];
        newCut[0] = 0;
        newCut[newCut.length-1] = n;

        for(int i=0; i<m; i++){
            newCut[i+1] = cuts[i];
        }
        return solve(1, cuts.length, newCut);
    }

    public int solve(int i, int j, int[] arr){
        if(i > j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int idx = i; idx <= j; idx++){
            int cost = arr[j+1] - arr[i-1] + solve(i, idx-1, arr) + solve(idx+1, j, arr);
            min = Math.min(min, cost);
        }
        return min;
    }*/

    //Memoization

    /*
    Integer[][] dp;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCut = new int[m+2];
        newCut[0] = 0;
        newCut[newCut.length-1] = n;
        dp = new Integer[newCut.length][newCut.length];

        for(int i=0; i<m; i++){
            newCut[i+1] = cuts[i];
        }
        return solve(1, cuts.length, newCut);
    }

    public int solve(int i, int j, int[] arr){
        if(i > j){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        if(dp[i][j] != null){
            return dp[i][j];
        }
        for(int idx = i; idx <= j; idx++){
            int cost = arr[j+1] - arr[i-1] + solve(i, idx-1, arr) + solve(idx+1, j, arr);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }*/

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newCut = new int[m+2];
        newCut[0] = 0;
        newCut[newCut.length-1] = n;
        int[][] dp = new int[newCut.length][newCut.length];

        for(int i=0; i<m; i++){
            newCut[i+1] = cuts[i];
        }
        for(int i=cuts.length; i>=1; i--){
            for(int j=1; j<=cuts.length; j++){
                if(i > j){
                    continue;
                }
                int min = Integer.MAX_VALUE;
                for(int idx = i; idx <= j; idx++){
                    int cost = newCut[j+1] - newCut[i-1] + dp[i][idx-1] + dp[idx+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][m];
    }       
}
