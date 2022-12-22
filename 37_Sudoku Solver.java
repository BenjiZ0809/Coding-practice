class Solution {
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') continue;
                for(char k='1'; k<='9'; k++) {
                    if(isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if(backTrack(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char k) {
        for(int i=0; i<9; i++) {
            if(board[row][i] == k) return false;
        }
        for(int i=0; i<9; i++) {
            if(board[i][col] == k) return false;
        }

        int rowStart = (row / 3) * 3;
        int colStart = (col / 3) * 3;
        for(int i=rowStart; i<rowStart+3; i++) {
            for(int j=colStart; j<colStart+3; j++) {
                if(board[i][j] == k) return false;
            }
        }
        return true;
    }
}
