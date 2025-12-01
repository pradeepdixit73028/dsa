class Solution {
    int count;
    public int totalNQueens(int n) {
       char[][] board = new char[n][n];
        count=0;
        generate(board, 0);
        return count; 
    }
    public void generate(char[][] board, int row) { 
        int n = board.length;
        if(row == n){
            count++;
            return;
        } 
        for(int j = 0; j < board[0].length ;j++) { 
            if(isSafe(board,row,j)) { 
                board[row][j] = 'Q'; 
                generate(board,row+1); 
                board[row][j] = '.'; 
            } 
        } 
    } 
    private static boolean isSafe(char[][] board, int row, int col) {
        for(int i = 0; i< row;i++){ 
            if(board[i][col] == 'Q')return false; 
        }
        int maxL= Math.min(row,col);
        for(int j =1; j<=maxL;j++){ 
            if(board[row-j][col-j] == 'Q')return false; 
        } 
        int maxR= Math.min(row,board.length-1-col);
        for(int j =1; j<=maxR;j++){ 
            if(board[row-j][col+j] == 'Q')return false; 
        } 
        return true; 
    } 
}