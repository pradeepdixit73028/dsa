class Solution {
    public boolean isGood(int[] nums) {
        int n=nums.length;

        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);   
        }

        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        if(max+1 !=n){
            return false;
        }
        
        for(int i=1;i<max;i++){
            if(!mp.containsKey(i) || mp.get(i)!=1){
                return false;
            }
        }
        if(!mp.containsKey(max) || mp.get(max)!=2){
            return false;
        }
        return true;
        
    }
    
    
    
}