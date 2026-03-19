class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int[][] prefix=new int[n][m];
        int[][] countx=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int diff=0;
                int cx=0;
                if(grid[i][j]=='X'){
                    diff=1;
                    cx=1;
                }
                if(grid[i][j]=='Y'){
                    diff=-1;
                }
                prefix[i][j]=diff;
                countx[i][j]=cx;
                if(i>0){
                    prefix[i][j]+=prefix[i-1][j];
                    countx[i][j]+=countx[i-1][j];
                }
                if(j>0){
                    prefix[i][j]+=prefix[i][j-1];
                    countx[i][j]+=countx[i][j-1];
                }
                if(i>0 && j>0){
                    prefix[i][j]-=prefix[i-1][j-1];
                    countx[i][j]-=countx[i-1][j-1];
                }
                if(prefix[i][j]==0 && countx[i][j]>0){
                    count++;
                }


            }
        }
        return count;
    }
}