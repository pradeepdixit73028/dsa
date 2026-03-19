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
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n=nums1.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=nums1[i]-nums2[i];

        }
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:ans){
            set.add(num);
            set.add(num+diff);
        }
        Map<Integer, Integer> map=new HashMap<>();
        int idx=0;
        for(int val:set) map.put(val,idx++);

        segTree st = new segTree(idx);
        long count=0;
        for(int j=0;j<n;j++){
            int r=map.get(ans[j]+diff);
            count+=st.query(0,0,idx-1,0,r);
            st.update(0,0,idx-1,map.get(ans[j]));
        }
            
        return count;
    }
}