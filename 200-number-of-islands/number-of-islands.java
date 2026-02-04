class Solution {
    int n,m;
    public int numIslands(char[][] grid){
        n=grid.length;
        m=grid[0].length;
        boolean[][] visited= new boolean[n][m];
		int count=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]=='1' && !visited[i][j]){
					count++;
					BFS(grid,visited,i,j);
				}
			}
		}
		return count;
	}
	public void BFS(char[][] grid,boolean[][] visited,int x,int y){
		Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x,y});
		visited[x][y]=true;
		int[][] movement={{0,1},{1,0},{0,-1},{-1,0}};
		while(!q.isEmpty()){
            int[] curr=q.poll();
    		int sx=curr[0],sy=curr[1];
			for(int[] d:movement){
				int nx=sx+d[0];
				int ny=sy+d[1];
				if(nx>=0 && nx<n && ny>=0 && ny<m){
					if(grid[nx][ny]=='1' && !visited[nx][ny]){
						visited[nx][ny]=true;
						q.add(new int[]{nx, ny});
					}
				}
			}
		}
	}
}