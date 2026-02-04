class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n=vals.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int temp=vals[i];
            int p=adjList.get(i).size();
            if(p>0){
                int[] arr= new int[p];
                for(int j=0;j<p;j++){
                    arr[j]=vals[adjList.get(i).get(j)];
                }
                Arrays.sort(arr);
                for(int j=0;j<Math.min(k,p);j++){
                    temp=Math.max(temp,temp+arr[p-j-1]);

                }
            }
                ans=Math.max(ans,temp);
        }
        return ans;
    }
}