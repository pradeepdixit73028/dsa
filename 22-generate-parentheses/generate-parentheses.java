class Solution {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        solve(result, "", 0, 0, n);
        return result;
    }
    private void solve(List<String> result, String curr, int oCount, int cCount, int n){
        if(oCount==n&&cCount==n){
            result.add(curr);
            return;
        }
        if(oCount<n){
            solve(result,curr+ "(",oCount+1,cCount,n);
        }
        if(cCount<oCount){
            solve(result,curr+ ")",oCount,cCount+1,n);
        }
    }
}