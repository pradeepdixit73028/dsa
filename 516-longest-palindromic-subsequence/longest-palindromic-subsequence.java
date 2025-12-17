class Solution {
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        StringBuilder sb = new StringBuilder(s);
        String t=sb.reverse().toString();
        return longestCommonSubsequence(s,t);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[] curr=new int[n+1];
        int[] prev=new int[n+1];
        Arrays.fill(prev,0);
        for(int i=1;i<=m;i++){
            curr[0]=0;
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j]=prev[j-1]+1;
                }else{
                    curr[j]=Math.max(curr[j-1],prev[j]);
                }
            }
            for(int j=0;j<=n;j++){
                prev[j]=curr[j];
            }

        }
        return prev[n];
    }
}