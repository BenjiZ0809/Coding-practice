//BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if(x == destination[0] && y == destination[1]) return true;
            for(int k=0; k<4; k++) {
                int newX = x;
                int newY = y;
                while(isValid(maze, newX + dx[k], newY + dy[k])) {
                    newX += dx[k];
                    newY += dy[k];
                }
                if(!visited[newX][newY]) {
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(maze[x][y] == 1) return false;
        return true;
    }
}

//DFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start[0], start[1], destination, visited);
    }
    
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    private boolean dfs(int[][] maze, int x, int y, int[] end, boolean[][] visited) {
        int m = maze.length;
        int n = maze[0].length;
        if(visited[x][y]) return false;
        visited[x][y] = true;
        if(x == end[0] && y == end[1]) return true;
        
        for(int k=0; k<4; k++) {
            int newX = x;
            int newY = y;
            while(isValid(maze, newX + dx[k], newY + dy[k])) {
                newX += dx[k];
                newY += dy[k];
            }
            if(dfs(maze, newX, newY, end, visited)) return true;
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(maze[x][y] == 1) return false;
        return true;
    }
}
