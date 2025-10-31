class Solution {
    public int maxDifference(String s) {
        int[] m=new int[26];
        int max=0,min=s.length();
        for(char c:s.toCharArray()){
            m[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(m[i]%2!=0){
                max=Math.max(max,m[i]);
            }
            if(m[i]%2==0 && m[i]>0){
                min=Math.min(min,m[i]);
            }
        }
        return max-min;
    }
}