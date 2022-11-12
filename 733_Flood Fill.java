//BFS
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int tar = image[sr][sc];
        if(tar == color) return image;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            image[curX][curY] = color;
            for(int k=0; k<4; k++) {
                int newX = curX + dx[k];
                int newY = curY + dy[k];
                if(isValid(image, newX, newY)) {
                    if(image[newX][newY] == tar) {
                        q.offer(new int[]{newX, newY});
                        
                    }
                }
            }
        }
        return image;
    }

    private boolean isValid(int[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        return true;
    }
}

//DFS
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int tar = image[sr][sc];
        if(tar == color) return image;
        dfs(image, sr, sc, tar, color);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int tar, int color) {
        int m = image.length;
        int n = image[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        if(image[x][y] != tar) return;
        image[x][y] = color;

        for(int k=0; k<4; k++) {
            dfs(image, x + dx[k], y + dy[k], tar, color);
        }
    }
}
