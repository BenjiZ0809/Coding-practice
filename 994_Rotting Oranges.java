//BFS
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
                if(grid[i][j] == 1) count++;
            }
        }

        int time = 0;
        while(!q.isEmpty() && count != 0) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                for(int k=0; k<4; k++) {
                    int newX = curX + dx[k];
                    int newY = curY + dy[k];
                    if(isValid(grid, newX, newY)) {
                        if(grid[newX][newY] == 1) {
                            q.offer(new int[]{newX, newY});
                            grid[newX][newY] = 2;
                            count--;
                        }
                    }
                }
            }
            time++;
        }
        return count == 0? time:-1;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }
}
