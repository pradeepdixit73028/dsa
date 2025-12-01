class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 1; 
        int sr = 0, sc = 0;
        for (int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }else if(grid[i][j] == 0){
                    count++;
                }
            }
        }    
        boolean[][] avilable = new boolean[row][col];
        return printpath(grid, sr, sc, avilable, count); 
    }
    public static int printpath(int[][] maze, int sr, int sc, boolean[][] avilable, int count){
        if(sr<0||sc< 0||sr>=maze.length||sc>=maze[0].length||maze[sr][sc]==-1||avilable[sr][sc]){
            return 0;
        }
        if(maze[sr][sc] == 2){
            return count == 0 ? 1 : 0; 
        }
        avilable[sr][sc] = true;
        int totalpaths = printpath(maze, sr + 1, sc, avilable, count - 1)+printpath(maze, sr, sc - 1, avilable, count - 1)+printpath(maze, sr, sc + 1, avilable, count - 1)+printpath(maze, sr - 1, sc, avilable, count - 1);
        avilable[sr][sc] = false;    
        return totalpaths;
    }
}