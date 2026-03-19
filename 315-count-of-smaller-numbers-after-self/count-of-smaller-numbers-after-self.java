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
            if(ql<=l && r<=qr) return tree[node];
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
    public List<Integer> countSmaller(int[] nums) {
        int[] temp=nums.clone();
        int n=nums.length;
        Arrays.sort(temp);
        Map<Integer,Integer> hm=new HashMap<>();
        int idx=0;
        for(int val:temp){
            if(!hm.containsKey(val)){
                hm.put(val,idx++);
            }
        }
        segTree seg=new segTree(idx);
        Integer[] ans=new Integer[n];

        for(int i=n-1;i>=0;i--){
            int val=hm.get(nums[i]);
            ans[i]=seg.query(0,0,idx-1,0,val-1);
            seg.update(0,0,idx-1,val);
        }
        return Arrays.asList(ans);
    }
}