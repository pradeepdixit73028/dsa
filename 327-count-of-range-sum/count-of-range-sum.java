class Solution {
    static class segTree{
        int n;
        int[] tree;
        public segTree(int n){
            this.n=n;
            tree=new int[6*n];
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
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefixSums=new long[n+1];
        TreeSet<Long> set=new TreeSet<>();
        set.add(0L);
        for(int i=0;i<n;i++){
            prefixSums[i+1]=prefixSums[i]+nums[i];
            set.add(prefixSums[i+1]);
            set.add(prefixSums[i+1]-lower);
            set.add(prefixSums[i+1]-upper);
        }
        Map<Long, Integer> map=new HashMap<>();
        int idx=0;
        for(Long val:set) map.put(val,idx++);

        segTree st = new segTree(idx);
        int count=0;
        st.update(1,0,idx-1,map.get(0L));
        for(int i=1;i<=n;i++){
            long currentSum = prefixSums[i];
            int l=map.get(currentSum-upper);
            int r=map.get(currentSum-lower);
            count +=st.query(1,0,idx-1,l,r);
            st.update(1,0,idx-1,map.get(currentSum));
        }

        return count;
    }
}