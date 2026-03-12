class Solution {
    public int subarraysDivByK(int[] nums, int k){
        int n=nums.length;
        HashMap<Integer, Integer> hs=new HashMap<>();
        hs.put(0,1);
        int count=0;
        int prefixSum=0;
        for(int i=0;i<n;i++){
            prefixSum=((prefixSum+nums[i])%k+k)%k;
             if (hs.containsKey(prefixSum)) {
                count += hs.get(prefixSum);
            }
            hs.put(prefixSum, hs.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}