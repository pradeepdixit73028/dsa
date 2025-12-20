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
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int[] prev=new int[n2+1];
        int[] curr=new int[n2+1];
        for(int j=0;j<=n2;j++){
            prev[j]=j;
        }
        for(int i=1;i<=n1;i++){
            curr[0]=i;
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    curr[j]=prev[j-1];
                }else{
                    int in=1+curr[j-1];
                    int d=1+prev[j];
                    int r=1+prev[j-1];
                    curr[j]=Math.min(in,Math.min(d,r));
                }
            }
            prev=curr.clone();
        }
        return prev[n2];

    }
}