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
        int n=grid.size();
        int m=grid.get(0).size();
        boolean[][][] visited=new boolean[n][m][health+1];
        if(grid.get(0).get(0)>=health) return false;
        return dfs(grid,0,0,visited,health);
        

    }
    public static boolean dfs(List<List<Integer>> grid,int i,int j,boolean[][][] visited, int health){
        int n=grid.size();
        int m=grid.get(0).size();
        if(i<0||j<0||i>=n||j>=m) return false;
            if(grid.get(i).get(j)==1){
                health=health-1;
            }
            if(health<=0){
                return false;
            }
            if(i==n-1&&j==m-1){
                return true;
            }
            if(visited[i][j][health]){
                return false;
            }
            visited[i][j][health]= true;
            boolean down = dfs(grid,i+1,j,visited,health);
            boolean right = dfs(grid,i,j+1,visited,health);
            boolean up = dfs(grid,i-1,j,visited,health);
            boolean left = dfs(grid,i,j-1,visited,health);
            return down||right||up||left;

    }
}
