class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minHel = new int[m][n];

        for(int[] row:minHel) Arrays.fill(row,Integer.MAX_VALUE);
        Deque<int[]> q=new LinkedList<>();
        int hel=grid[0][0];

        q.offerFirst(new int[]{0,0,hel});
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};

        while (!q.isEmpty()) {
            int[] curr=q.poll();
            int r=curr[0],c=curr[1],h=curr[2];

            for(int[] d:dirs){
                int nr=r+d[0],nc=c+d[1];
                if(nr>=0&&nr<m&&nc>=0&&nc<n){
                    int nexthel=h+grid[nr][nc];

                    if(nexthel<minHel[nr][nc]){
                        minHel[nr][nc]=nexthel;

                        if(grid[nr][nc]==0){
                            q.offerFirst(new int[]{nr,nc,nexthel});
                        }else{
                            q.offerLast(new int[]{nr,nc,nexthel});
                        }
                    }
                }
            }
        }
        return minHel[m-1][n-1];
    }
}