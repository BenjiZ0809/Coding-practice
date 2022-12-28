//DFS backTrack original(slow)
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0) return new ArrayList<>();
        if(board[0] == null || board[0].length == 0) return new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> wordSet = new HashSet<>();
        Set<String> prefix = new HashSet<>();
        for(String word:words) {
            for(int i=0; i<word.length(); i++) {
                prefix.add(word.substring(0, i + 1));
            }
            wordSet.add(word);
        }

        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                backTrack(board, wordSet, visited, i, j, prefix, sb, res);
                visited[i][j] = false;
                sb.delete(0, sb.length());
            }
        }
        List<String> result = new ArrayList<>(res);
        return result;
    }

    private void backTrack(char[][] board, Set<String> wordSet, boolean[][] visited, int x, int y, Set<String> prefix, StringBuilder sb, Set<String> res) {
        if(!prefix.contains(sb.toString())) return;
        if(wordSet.contains(sb.toString())) res.add(sb.toString());

        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if(isValid(board, visited, newX, newY)) {
                sb.append(board[newX][newY]);
                visited[newX][newY] = true;
                backTrack(board, wordSet, visited, newX, newY, prefix, sb, res);
                sb.deleteCharAt(sb.length() - 1);
                visited[newX][newY] = false;
            }
        }
    }

    private boolean isValid(char[][] board, boolean[][] visited, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if(visited[x][y]) return false;
        return true;
    }
}
