// bfs
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    int temp = bfs(grid, i, j);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    public int bfs(int[][] grid, int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        grid[x][y] = 0;
        int temp = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                for(int k=0; k<4; k++) {
                    int newX = curX + dx[k];
                    int newY = curY + dy[k];
                    if(isValid(grid, newX, newY)) {
                        temp++;
                        q.offer(new int[] {newX, newY});
                        grid[newX][newY] = 0;
                    }
                }
            }
        }
        return temp;
    }

    public boolean isValid(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        if(grid[x][y] == 0) return false;
        return true;
    }
}

// dfs
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int res = 0;
   

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    int temp = dfs(grid, i, j);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {
        grid[x][y] = 0;

        int temp = 1;
        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if(isValid(grid, newX, newY)) {
                temp += dfs(grid, newX, newY);
            }
        } 
        return temp;
    }

    public boolean isValid(int[][] grid, int x, int y) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return false;
        if(grid[x][y] == 0) return false;
        return true;
    }
}
