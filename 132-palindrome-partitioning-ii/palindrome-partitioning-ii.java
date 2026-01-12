class Solution {
/*
    public int minCut(String s) {
        return solve(s, 0) - 1;
    }

    public int solve(String s, int i){
        if(i == s.length()){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                int ans = 1 + solve(s, j+1);
                min = Math.min(min, ans);
            }
        }
        return min;
    }
    */

    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)){
                return false;
            }
        }
        return true;
    }

    //Memoization
    
    Integer[] dp;
    public int minCut(String s) {
        dp = new Integer[s.length()];
        return solve(s, 0) - 1;
    }

    public int solve(String s, int i){
        if(i == s.length()){
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        int min = Integer.MAX_VALUE;

        for(int j = i; j < s.length(); j++) {
            if(isPalindrome(s, i, j)) {
                int ans = 1 + solve(s, j+1);
                min = Math.min(min, ans);
            }
        }
        return dp[i] = min;
    }
    

    //Tabulation
    /*public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[s.length()+1];
        dp[n] = 0;
        
        for(int i = n-1; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(s, i, j)) {
                    int ans = 1 + dp[j+1];
                    min = Math.min(min, ans);
                }
            }
            dp[i] = min;
        } 
        return dp[0]-1;
    }*/
}