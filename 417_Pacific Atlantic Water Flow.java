// dfs
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            dfs(heights, i, 0, -1, pacific);
            dfs(heights,i, m-1, -1, atlantic);
        }
        
        for (int j=0; j<m; j++){
            dfs(heights, 0, j, -1, pacific);
            dfs(heights, n-1, j, -1, atlantic);
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> minires = new ArrayList<>();
                    minires.add(i);
                    minires.add(j);
                    res.add(minires);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int x, int y, int prev, boolean[][] grid) {
        grid[x][y] = true;
        
        for(int k=0; k<4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if(isValid(heights, newX, newY, heights[x][y], grid)) {
                dfs(heights, newX, newY, heights[x][y], grid);
            }
        }
    }

    public boolean isValid(int[][] heights, int x, int y, int prev, boolean[][] grid) {
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length) return false;
        if(heights[x][y] < prev || grid[x][y]) return false;
        return true;
    }
