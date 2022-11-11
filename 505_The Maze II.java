class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] row:dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Queue<State> q = new ArrayDeque<>();
        q.offer(new State(start[0], start[1], 0));

        int res = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            State cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curD = cur.d;
            if(curX == destination[0] && curY == destination[1]) {
                res = Math.min(res, curD);
            }
            if(dist[curX][curY] < curD) continue;
            for(int k=0; k<4; k++) {
                int newX = curX;
                int newY = curY;
                int newD = curD;
                while(isValid(maze, newX + dx[k], newY + dy[k])) {
                    newX += dx[k];
                    newY += dy[k];
                    newD++;
                }
                if(dist[newX][newY] > newD) {
                    q.offer(new State(newX, newY, newD));
                    dist[newX][newY] = newD;
                }
            }
        }
        return res == Integer.MAX_VALUE? -1:res;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(maze[x][y] == 1) return false;
        return true;
    }

    class State {
        int x;
        int y;
        int d;
        public State(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    } 
}

//Use PriorityQueue
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for(int[] row:dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }    

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curD = cur[2];
            if(dist[curX][curY] < curD) continue;
            if(curX == destination[0] && curY == destination[1]) {
                return curD;
            }
            for(int k=0; k<4; k++) {
                int newX = curX;
                int newY = curY;
                int newD = curD;
                while(isValid(maze, newX + dx[k], newY + dy[k])) {
                    newX += dx[k];
                    newY += dy[k];
                    newD++;
                }
                if(dist[newX][newY] > newD) {
                    pq.offer(new int[]{newX, newY, newD});
                    dist[newX][newY] = newD;
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(maze[x][y] == 1) return false;
        return true;
    } 
}
