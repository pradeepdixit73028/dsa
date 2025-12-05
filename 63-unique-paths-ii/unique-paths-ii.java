public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null||obstacleGrid.length==0||obstacleGrid[0][0]==1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev= new int[n];
        int[] cur= new int[n];
        prev[0]=1;
        for(int i=0;i<m;i++){
            cur[0]=obstacleGrid[i][0]==1 ? 0: prev[0];
            for(int j=1;j<n;j++){
                cur[j]=obstacleGrid[i][j]==1 ? 0:cur[j-1]+prev[j];
            }
            System.arraycopy(cur, 0, prev, 0, n);
        }
        return prev[n-1];
    }
}