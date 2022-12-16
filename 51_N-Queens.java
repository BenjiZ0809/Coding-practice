class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] ch:board) {
            Arrays.fill(ch, '.');
        }

        backTrack(n, 0, board, res);
        return res;
    }

    private void backTrack(int n, int row, char[][] board, List<List<String>> res) {
        if(row == n) {
            res.add(arrayToString(board));
            return;
        }

        for(int col=0; col<n; col++) {
            if(isValid(row, col, n, board)) {
                board[row][col] = 'Q';
                backTrack(n, row + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] board) {
        //检查列
        for(int i=0; i<row; i++) {
            if(board[i][col] == 'Q') return false;
        }
        //检查行
        for(int i=0; i<col; i++) {
            if(board[row][i] == 'Q') return false;
        }
        //检查45度
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') return false;
        }
        //检查135度
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }

    private List<String> arrayToString(char[][] board) {
        List<String> minires = new ArrayList<>();
        for(char[] ch:board) {
            minires.add(new String(ch));
        }
        return minires;
    } 
}
