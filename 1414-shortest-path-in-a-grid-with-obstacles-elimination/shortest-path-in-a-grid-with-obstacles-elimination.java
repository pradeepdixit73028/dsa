class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][][] visited=new boolean[m][n][k+1];
        Queue<int[]> q=new LinkedList<>();
        if(grid[0][0]==1&&k<1) return -1;
        visited[0][0][0]=true;
        q.offer(new int[]{0,0,0,0});
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0],j=curr[1],steps=curr[2],oc=curr[3];
            if(i==m-1 && j==n-1) return steps;
            for(int[] d:dirs){
                int nr=i+d[0];
                int nc=j+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int noc=oc+grid[nr][nc];                    
                    if(noc<=k && !visited[nr][nc][noc]){
                        visited[nr][nc][noc]=true;
                        q.offer(new int[]{nr,nc,steps+1,noc});
                    }
                    
                }
            }
        }
        return -1;
    }
}