class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n=heights.length;
        int q=queries.length;
        int[] tree=new int[4*n];
        int[] ans=new int[q];
        buildTree(0,0,n-1,heights,tree);
        for(int i=0;i<q;i++){
            int alice=Math.min(queries[i][0],queries[i][1]);
            int bob=Math.max(queries[i][0],queries[i][1]);
            if(alice==bob) ans[i]=alice;
            else if(heights[alice]<heights[bob]) ans[i]=bob;
            else{
                ans[i]=solve(0,0,n-1,bob+1,n-1,heights[alice],tree);
            }
            
        }
        return ans;
        
    }
    public static void buildTree(int idx,int start,int end,int[] arr,int[] tree){
        if(start==end){
            tree[idx]=arr[start];
            return;
        }
        int mid=start+(end-start)/2;
        int left=2*idx+1;
        int right=2*idx+2;
        buildTree(left,start,mid,arr,tree);//left
        buildTree(right,mid+1,end,arr,tree);//right
        tree[idx]=Math.max(tree[left],tree[right]);//root sum
    }
    public int solve(int idx,int left,int right,int qs,int qe,int target,int[] tree){
        if(right<qs || left>qe) return -1;
        if(tree[idx]<=target) return -1;
        if(left==right){
            return left;
        }
        int mid=left+(right-left)/2;
        int leftchild=2*idx+1;
        int rightchild=2*idx+2;
        int ans1=solve(leftchild,left,mid,qs,qe,target,tree);
        int ans2=solve(rightchild,mid+1,right,qs,qe,target,tree);
        if(ans1!=-1) return ans1;
        else return ans2;
    }
    
}