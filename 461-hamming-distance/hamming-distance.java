class Solution {
    public int hammingDistance(int x, int y) {
        int z=x^y;
        String s=Integer.toBinaryString(z);
        int ans=0;
        for(char ch:s.toCharArray()){
            if(ch-'0'==1) ans++;
        }
        return ans;
    }
}