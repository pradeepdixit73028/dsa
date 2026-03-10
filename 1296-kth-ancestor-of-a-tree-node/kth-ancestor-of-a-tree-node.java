class TreeAncestor {
    static int log=20;
    static int[][] up;
    public TreeAncestor(int n, int[] parent){
        up=new int[n][log];
        for(int i=0;i<n;i++){
            up[i][0]=parent[i];
        }
        for(int i=1;i<log;i++){
            for(int j=0;j<n;j++){
                if(up[j][i-1]!=-1){
                    up[j][i]=up[up[j][i-1]][i-1];
                }
                else{
                    up[j][i]=-1;
                }
            }
        }

    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0;i<log;i++){
            if((k & (1 << i)) != 0){
                node=up[node][i];
                if(node==-1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */