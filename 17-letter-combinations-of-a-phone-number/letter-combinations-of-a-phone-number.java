class Solution {
    String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        helper(digits,0,new StringBuilder(),ans);
        return ans;
    }
    public void helper(String digits,int index,StringBuilder sb,List<String> ans){
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        for(char c:map[digits.charAt(index)-'0'].toCharArray()){
            sb.append(c);
            helper(digits,index+1,sb,ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}