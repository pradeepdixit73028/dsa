class Solution {
    static class segTree{
        int n;
        int[] tree;
        public segTree(int n){
            this.n=n;
            tree=new int[4*n];
        }
        public int query(int node,int l,int r,int ql,int qr){
            if(l>qr || r<ql) return 0;
            if(l>=ql && r<=qr) return tree[node];
            int mid=(l+r)/2;
            return query(2*node+1,l,mid,ql,qr)+query(2*node+2,mid+1,r,ql,qr);
        }
        public void update(int node,int l,int r,int ser){
            if(l==r){
                tree[node]++;
                return;
            }
            int mid=(l+r)/2;
            if(ser<=mid) update(2*node+1,l,mid,ser);
            else update(2*node+2,mid+1,r,ser);
            tree[node]=tree[2*node+1]+tree[2*node+2];
        }
    }
    public int reversePairs(int[] nums) {
        int n=nums.length;
        TreeSet<Long> ts=new TreeSet<>();
        for(int num:nums){
            ts.add((long)num);
            ts.add((long)num*2);
        }
        List<Long> list=new ArrayList<>(ts);
        HashMap<Long,Integer> map=new HashMap<>();
        int idx=0;
        for(int i=0;i<list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put((long)list.get(i),idx++);
            }
        }
         segTree seg=new segTree(idx);
        int ans=0;
        for(int j=0;j<n;j++){
            int val=map.get((long)(nums[j]*2L));
            ans+=seg.query(0,0,idx-1,val+1,idx-1);
            seg.update(0,0,idx-1,map.get((long)(nums[j])));
        }
        return ans;
    }
}