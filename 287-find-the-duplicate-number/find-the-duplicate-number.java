class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.containsKey(nums[i])) {
               map.put(nums[i],map.get(nums[i]) + 1); // freq increase
            } else {
               map.put(nums[i],1);
            }
        }
        int max =Integer.MIN_VALUE;;
        int majorityElement = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                majorityElement = entry.getKey();
            }
        }

        return majorityElement;
    }
}