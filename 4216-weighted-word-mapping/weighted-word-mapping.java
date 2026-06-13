class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        char[] arr=new char[words.length];
        for(int i=0;i<words.length;i++){
            int sum=0;
            for(char ch:words[i].toCharArray()){
                sum+=weights[ch-'a'];
            }
            
            arr[i]=(char)('z'-(sum%26));
            
        }
        return new String(arr);
    }
}