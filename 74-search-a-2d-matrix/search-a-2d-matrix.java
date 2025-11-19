class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;
        return search(matrix,left,right,n,target);
    }
    public boolean search(int[][] matrix,int left,int right,int n,int target){
        if(left>right){
            return false;
        }
        int mid=left+(right-left)/2;
        int mid_value=matrix[mid/n][mid%n];
        if(mid_value==target){
            return true;
        }
        else if(mid_value>target){
            return search(matrix,left,mid-1,n,target);
        }
        else{
            return search(matrix,mid+1,right,n,target);
        }
    }
}