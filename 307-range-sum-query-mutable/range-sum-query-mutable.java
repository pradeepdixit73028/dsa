class NumArray {
    int[] seg;
    int[] arr;
    int n;
    public NumArray(int[] nums){
        n=nums.length;
        seg=new int[4*n];
        arr=nums;
        buildtree(0,0,n-1);
    }
    public void buildtree(int idx,int l,int r){
        if(l==r){
            seg[idx]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildtree(2*idx+1,l,mid);//left
        buildtree(2*idx+2,mid+1,r);//right
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];//root sum
    }
    
    public void update(int index, int val) {
        updatetree(0,index,val,0,n-1);
    }
    public void updatetree(int idx,int i,int val,int l,int r){
        if(l==r){
            seg[idx]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(i<=mid){
            updatetree(2*idx+1,i,val,l,mid);//left
        }else{
            updatetree(2*idx+2,i,val,mid+1,r);//right
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];//update root
    }
    
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
    public int query(int idx,int l,int r,int a,int b){
        if(r<a || l>b){ //no overlapping
            return 0;
        }
        if(l>=a && r<=b){//fully overlap
            return seg[idx];
        }
        int mid=l+(r-l)/2;
        int left=query(2*idx+1,l,mid,a,b);
        int right=query(2*idx+2,mid+1,r,a,b);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */