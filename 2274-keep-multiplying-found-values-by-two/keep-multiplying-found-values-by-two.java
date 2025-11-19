class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set= new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int a=original;
        while(set.contains(a)){
            a *=2;
        }
        return a;
    }
}