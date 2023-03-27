class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        int row = 0;
        int[] col = new int[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i == 0 || grid[i - 1][j] == 'W') {
                    col[j] = maxColKill(grid, i, j);
                }
                if(j == 0 || grid[i][j - 1] == 'W') {
                    row = maxRowKill(grid, i, j);
                }
                if(grid[i][j] == '0') {
                    res = Math.max(res, row + col[j]);
                }
            }
        }
        return res;
    }

    private int maxRowKill(char[][] grid, int row, int col) {
        int count = 0;
        int index = col;
        while(index < grid[0].length && grid[row][index] != 'W') {
            if(grid[row][index] == 'E') count++;
            index++;
        }
        return count;
    }

    private int maxColKill(char[][] grid, int row, int col) {
        int count = 0;
        int index = row;
        while(index < grid.length && grid[index][col] != 'W') {
            if(grid[index][col] == 'E') count++;
            index++;
        }
        return count;
    }
}
