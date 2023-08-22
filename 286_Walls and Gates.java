class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(rooms[i][j] == 0) q.offer(new int[] {i, j});
            }
        }
        
        int dist = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];
                for(int k=0; k<4; k++) {
                    int newX = curX + dx[k];
                    int newY = curY + dy[k];
                    if(isValid(rooms, newX, newY)) {
                        q.offer(new int[] {newX, newY});
                        rooms[newX][newY] = Math.min(dist, rooms[newX][newY]);
                    }
                }
            }
            dist++;
        }
    }

    public boolean isValid(int[][] rooms, int x, int y) {
        if(x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length) return false;
        if(rooms[x][y] != INF ) return false;
        return true;
    }
}
