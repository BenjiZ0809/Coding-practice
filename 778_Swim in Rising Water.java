// Dijkstra
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        visited[0][0] = true;
        pq.offer(new int[] {0, 0, grid[0][0]});

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curT = cur[2];
            if(curX == n - 1 && curY == n - 1) return curT;
            for(int k=0; k<4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                if(newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                if(visited[newX][newY]) continue;
                pq.offer(new int[] {newX, newY, Math.max(curT, grid[newX][newY])});
                visited[newX][newY] = true;
            }
        }   
        return -1;
    }
}
