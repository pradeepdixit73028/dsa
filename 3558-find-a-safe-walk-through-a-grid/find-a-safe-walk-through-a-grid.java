class Solution {
    static class Pair{
        int a;
        int b;
        public Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] minHel = new int[m][n];
        for(int[] row:minHel) Arrays.fill(row,Integer.MAX_VALUE);
        Deque<int[]> q=new LinkedList<>();
        int hel=grid.get(0).get(0);
        minHel[0][0]=hel;
        q.offerFirst(new int[]{0,0,hel});
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while (!q.isEmpty()) {
            int[] curr=q.poll();
            int r=curr[0],c=curr[1],hLost=curr[2];
            if(r==m-1&&c==n-1){
                return health-hLost>=1;
            }
            for(int[] d:dirs){
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n){
                    int nextCost=hLost+grid.get(nr).get(nc);
                    if(nextCost<minHel[nr][nc]){
                        minHel[nr][nc]=nextCost;
                        if(grid.get(nr).get(nc)==0){
                            q.offerFirst(new int[]{nr,nc,nextCost});
                        }else{
                            q.offerLast(new int[]{nr,nc,nextCost});
                        }
                    }
                }
            }
        }
        
        return false;
    }
}