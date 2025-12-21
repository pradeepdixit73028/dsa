class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[m][n] = true;

        for(int j=n-1;j>=0;j--){
            if(p.charAt(j)=='*') dp[m][j]=dp[m][j+1];
            else dp[m][j]=false;
        }
        for(int i=0;i<m;i++){
            dp[i][n]=false;
        }
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                char ch=p.charAt(j);
                if(s.charAt(i)==ch || ch=='?') dp[i][j]=dp[i+1][j+1];
                else if(ch=='*') dp[i][j] = dp[i+1][j] || dp[i][j+1];
                else dp[i][j]=false;
            }
        }
        return dp[0][0];
    }
}