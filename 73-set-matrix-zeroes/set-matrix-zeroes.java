class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        ArrayList<int[]> zeros=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    zeros.add(new int[]{i,j});
                }
            }
        }
        for(int i=0;i<zeros.size();i++){
            int[] arr=zeros.get(i);
            int a=arr[0];
            int b=arr[1];
            for(int j=0;j<n;j++){
                matrix[j][b]=0;
            }
            for(int j=0;j<m;j++){
                matrix[a][j]=0;
            }
        }
    }
}