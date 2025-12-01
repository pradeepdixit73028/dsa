class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target){
    List<List<Integer>> l = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(l, new ArrayList<>(), nums, target, 0);
    return l;  
}
private void backtrack(List<List<Integer>> list, List<Integer> tl, int [] nums, int remain, int start){
    if(remain<0) return;
    else if(remain==0) list.add(new ArrayList<>(tl));
    else{
        for(int i = start; i < nums.length; i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            tl.add(nums[i]);
            backtrack(list, tl, nums, remain - nums[i], i + 1);
            tl.remove(tl.size() - 1); 
        }
    }
} 
}