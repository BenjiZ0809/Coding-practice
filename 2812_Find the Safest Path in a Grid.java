class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] dist = getDist(grid);
        int n = dist.length;
        int m = dist[0].length;
        int left = 0;
        int right = 2 * n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(hasValidPath(dist, mid)) left = mid + 1;
            else right = mid;
        }
        return left - 1;
        
    }

    public boolean hasValidPath(int[][] dist, int safe) {
        int n = dist.length;
        int m = dist[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        q.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            if(dist[curX][curY] < safe) continue;
            if(curX == n - 1 && curY == m - 1) return true;
            for(int k=0; k<4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY]) continue;
                q.offer(new int[] {newX, newY});
                visited[newX][newY] = true;
            }
        }
        return false;
    }

    public int[][] getDist(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] dist = new int[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid.get(i).get(j) == 1) {
                    q.offer(new int[] {i, j});
                    continue;
                }
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }

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
                    if(newX < 0 || newX >= n || newY < 0 || newY >= m || dist[newX][newY] != Integer.MAX_VALUE) continue;
                    q.offer(new int[] {newX, newY});
                    dist[newX][newY] = temp;
                }
            }
            temp++;
        }
        return dist;
    }
}
