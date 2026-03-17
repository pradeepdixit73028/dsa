class Solution {
    static int[] tree;
    static int[] arr;
    static int n;
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        n=heights.length;
        arr=heights;
        int q=queries.length;
        tree=new int[4*n];
        int[] ans=new int[q];
        buildTree(0,0,n-1);
        for(int i=0;i<q;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            if(a>b){
                int temp=a;
                a=b;
                b=temp;
            }
            if(a==b) ans[i]=a;
            else if(heights[a]<heights[b]) ans[i]=b;
            else{
                ans[i]=solve(0,0,n-1,b+1,n-1,heights[a]);
            }
            
        }
        return ans;
        
    }
    public static void buildTree(int idx,int start,int end){
        if(start==end){
            tree[idx]=arr[start];
            return;
        }
        int mid=start+(end-start)/2;
        int left=2*idx+1;
        int right=2*idx+2;
        buildTree(left,start,mid);//left
        buildTree(right,mid+1,end);//right
        tree[idx]=Math.max(tree[left],tree[right]);//root sum
    }
    public int solve(int idx,int left,int right,int qs,int qe,int target){
        if(right<qs || left>qe) return -1;
        if(tree[idx]<=target) return -1;
        if(left==right){
            return left;
        }
        int mid=left+(right-left)/2;
        int leftchild=2*idx+1;
        int rightchild=2*idx+2;
        int ans1=solve(leftchild,left,mid,qs,qe,target);
        int ans2=solve(rightchild,mid+1,right,qs,qe,target);
        if(ans1!=-1) return ans1;
        else return ans2;
    }
    
}