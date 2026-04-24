class Solution {
    public class pair{
        int x,y,dis;
        public pair(int x,int y,int dis){
            this.x=x;
            this.y=y;
            this.dis=dis;
        }
    }
    int[][] movement={{0,1},{0,-1},{-1,0},{1,0}};
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][m];
        int one=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.offer(new pair(i,j,0));
                    vis[i][j]=true;
                    one++;
                }
            }
        }
        if(one==0 || one==n*m) return -1;
        int maxdis=0;
        while(!q.isEmpty()){
            pair curr=q.poll();
            int r=curr.x;
            int c=curr.y;
            int d=curr.dis;
            maxdis=Math.max(maxdis,d);
            for(int[] move:movement){
                int newr=r+move[0],newc=c+move[1];
                if(newr>=0 && newc>=0 && newr<n && newc<m && !vis[newr][newc]){
                    q.offer(new pair(newr,newc,d+1));
                    vis[newr][newc]=true;
                }

            }
        }
        return maxdis;
    }
}