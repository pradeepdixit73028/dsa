class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            String s=String.valueOf(nums[i]);
            for(char ch:s.toCharArray()){
                ans.add(ch-'0');
            }

        }
        int size=ans.size();
        int[] res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=ans.get(i);
        }
        return res;
    }
}