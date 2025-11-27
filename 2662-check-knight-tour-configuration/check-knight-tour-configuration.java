class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        return helper(grid,0,0,0);
    }
    private boolean helper(int[][] grid,int r,int c,int num){
        int n=grid.length;
        if(num==n*n-1) return true;
        int i,j;
        //
        i=r-2;
        j=c+1;
        if(i>=0&&j<n&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1);    
        //
        i=r-2;
        j=c-1;
        if(i>=0&&j>=0&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        //
        i=r+2;
        j=c-1;
        if(i<n&&j>=0&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        //
        i=r+2;
        j=c+1;
        if(i<n&&j<n&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        //
        i=r-1;
        j=c+2;
        if(i>=0&&j<n&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        //
        i=r-1;
        j=c-2;
        if(i>=0&&j>=0&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        //
        i=r+1;
        j=c+2;
        if(i<n&&j<n&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1); 
        i=r+1;
        j=c-2;
        if(i<n&&j>=0&&grid[i][j]==num+1)
            return helper(grid,i,j,num+1);
        return false; 
    }
}