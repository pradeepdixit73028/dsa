class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        generate(board, 0);
        return res;
    }
    public void generate(char[][] board, int row) { 
        int n = board.length;
        if(row == n){
            List<String> l=new ArrayList<>();
            for(int i=0;i<n;i++){
                l.add(new String(board[i]));
            }
            res.add(l);
            return;
        } 
        for(int j = 0; j < board[row].length ;j++) { 
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
