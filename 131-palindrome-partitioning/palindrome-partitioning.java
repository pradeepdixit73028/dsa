class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        helper(s,0,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(String s,int i,List<String> path,List<List<String>> ans){
        int n=s.length();
        if(i==n){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j=i;j<n;j++){
            if(ispalindrome(s,i,j)){
                path.add(s.substring(i,j+1));
                helper(s,j+1,path,ans);
                path.remove(path.size()-1);
            }
        }
    }
    public boolean ispalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}