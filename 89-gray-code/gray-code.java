class Solution {
    public List<Integer> grayCode(int n) {
        int s = 1 << n;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s; i++){
            res.add(i^(i >> 1));
        }
        return res;
    }
}