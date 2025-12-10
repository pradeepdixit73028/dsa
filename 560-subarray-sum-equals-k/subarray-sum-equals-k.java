class Solution {
    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> hs = new HashMap<>();
        hs.put(0, 1);
        int total = 0, count = 0;
        for (int n : nums){
            total += n;
            if (hs.containsKey(total - k)){
                count += hs.get(total - k);
            }
            hs.put(total, hs.getOrDefault(total, 0) + 1);
        }
        return count;        
    }
}