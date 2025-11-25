class Solution {
    public char kthCharacter(int k){
        int l = 0;
        while((1 << l) < k){
            l++;
        }
        return helper(k, l);
    }
    public char helper(int k, int l){
        if(l== 0) return 'a'; 
        int half= 1<<(l-1); 
        if(k <= half) return helper(k, l-1);
        else{
            char ch = helper(k-half,l-1);
            return (char)(((ch -'a'+1) % 26) +'a'); 
        }
    }
}