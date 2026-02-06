class Solution {
    public static class Pair{
	    public int x,y,time;
	    public Pair(int x,int y,int time){
	        this.x=x;
    	    this.y=y;
            this.time=time;
	    }
    }
    static int n,m;
    static int[][] movement={{0,1},{0,-1},{-1,0},{1,0}};
    int maxtime=0;
    public int orangesRotting(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        //boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
		    for(int j=0;j<m;j++){
		        if(grid[i][j]==2){
			        q.offer(new Pair(i,j,0));
	   	        }
                else if(grid[i][j]==1){
                    fresh++;
                }
		    }
        }
        if(fresh==0) return 0;
       	while(!q.isEmpty()){
            Pair curr=q.poll();
            int R=curr.x;
            int C=curr.y;
            int T=curr.time;
            maxtime=Math.max(maxtime,T);
            // if(fresh==0){
            //     break;
            // }
            for(int[] d:movement){
                int nx=R+d[0];
                int ny=C+d[1];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                    grid[nx][ny]=2;
                    fresh--;
                    q.offer(new Pair(nx,ny,T+1));
                }
            }
        }
        return (fresh==0) ? maxtime:-1;
    }
}