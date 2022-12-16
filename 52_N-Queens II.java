class Solution {
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ch:board) Arrays.fill(ch, '.');
        return backTrack(n, 0, board);
    }

    private int backTrack(int n, int row, char[][] board) {
        if(row == n) return 1;
        int count = 0;
        for(int col=0; col<n; col++) {
            if(isValid(n, row, col, board)) {
                board[row][col] = 'Q';
                count += backTrack(n, row + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }

    private boolean isValid(int n, int row, int col, char[][] board) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        for(int i=0; i<col; i++) {
            if(board[row][i] == 'Q') return false;
        }
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        for(int i=row-1,j=col+1; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
}
