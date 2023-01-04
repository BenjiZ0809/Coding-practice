class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[] dx = new int[]{0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0, 1, 1, -1, -1};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int count = 0;
                for(int k=0; k<8; k++) {
                    int newX = i + dx[k];
                    int newY = j + dy[k];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                    if(board[newX][newY] == 1 || board[newX][newY] == 10) count++;
                }

                if(board[i][j] == 0) {
                    if(count == 3) {
                        board[i][j] = 11;
                    }
                }
                if(board[i][j] == 1) {
                    if(!(count >= 2 && count <= 3)) {
                        board[i][j] = 10;
                    }
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 10) board[i][j] = 0;
                if(board[i][j] == 11) board[i][j] = 1;
            }
        }
    }
}
