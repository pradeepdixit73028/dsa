class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> l = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(l, new ArrayList<>(), nums, target, 0);
    return l;
}

private void backtrack(List<List<Integer>> list, List<Integer> tl, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tl));
    else{ 
        for(int i = start; i < nums.length; i++){
            tl.add(nums[i]);
            backtrack(list, tl, nums, remain - nums[i], i);
            tl.remove(tl.size() - 1);
        }
    }
}
}