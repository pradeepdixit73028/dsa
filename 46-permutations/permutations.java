class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] isvisited= new boolean[nums.length];
        List<List<Integer>> ans = new ArrayList<>();
        permutation(nums,ans,new ArrayList<Integer>(),isvisited);
        return ans;
    }
    public static void permutation(int[]nums,List<List<Integer>> ans,ArrayList<Integer> temp, boolean[] isvisited){
        int n=nums.length;
        if(temp.size()==n){
            ArrayList<Integer> res = new ArrayList<>(temp);
            ans.add(res);
        }
        for(int i=0;i<n;i++){
            if(isvisited[i]==true) continue;
            isvisited[i]=true;
            temp.add(nums[i]);
            permutation(nums,ans,temp,isvisited);
            isvisited[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}