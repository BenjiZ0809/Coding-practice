class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dfs(board, word, 0, i, j)) return true;
            }
        }    
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y) {
        if(index == word.length()) return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
        if(board[x][y] != word.charAt(index)) return false;
        char temp = board[x][y];
        board[x][y] = '!';
        boolean res = (dfs(board, word, index + 1, x + 1, y) ||
                       dfs(board, word, index + 1, x - 1, y) ||
                       dfs(board, word, index + 1, x, y + 1) ||
                       dfs(board, word, index + 1, x, y - 1));
        board[x][y] = temp;
        return res;
    }
}
