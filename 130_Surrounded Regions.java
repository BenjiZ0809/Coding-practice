class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++) {
            if(board[i][0] == 'O') dfs(board, i, 0);
            if(board[i][m - 1] == 'O') dfs(board, i, m - 1);
        }
        for(int j=0; j<m; j++) {
            if(board[0][j] == 'O') dfs(board, 0, j);
            if(board[n - 1][j] == 'O') dfs(board, n - 1, j);
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if(board[x][y] != 'O') return;
        board[x][y] = 'T';

        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            dfs(board, newX, newY);
        }
    }
}
