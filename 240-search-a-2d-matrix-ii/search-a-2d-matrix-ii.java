class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=0;
        int n=matrix[0].length-1;
        return helper(matrix,target,m,n);
    }
    public boolean helper(int[][] matrix,int target,int m,int n){
        if(m>=matrix.length||n<0){
            return false;
        }
        if(matrix[m][n]==target){
            return true;
        }else if(matrix[m][n]<target){
            return helper(matrix,target,m+1,n);
        }else{
            return helper(matrix,target,m,n-1);
        }
    }
}