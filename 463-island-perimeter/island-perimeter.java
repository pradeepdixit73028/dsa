class Solution {
    static int n,m;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,1,-1};
    public int islandPerimeter(int[][] grid) {
       n=grid.length;
        m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&!visited[i][j]){
                    ans+=dfs(grid,visited,i,j);
                }
            }
        }
        return ans;
    }
    public static int dfs(int[][] grid,boolean[][] visited,int i,int j){
        if(i<0||i>=n||j<0||j>=m||grid[i][j]==0) return 1;
        if(visited[i][j]) return 0;
        int ans=0;
        visited[i][j]=true;
        for(int a=0;a<4;a++){
            ans+=dfs(grid,visited,i+dx[a],j+dy[a]);
        }
        return ans;
    } 
    
}