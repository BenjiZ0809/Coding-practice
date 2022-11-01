//BFS approach
class Solution {
    public int numIslands(char[][] grid) {
       if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }
    
    class Coor {
        int x;
        int y;
        public Coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<Coor> q = new ArrayDeque<>();
        q.offer(new Coor(x, y));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Coor cur = q.poll();
            for(int k=0; k<4; k++) {
                int newX = cur.x + dx[k];
                int newY = cur.y + dy[k];
                if(!isValid(grid, newX, newY, visited)) continue;
                q.offer(new Coor(newX, newY));
                visited[newX][newY] = true;
            }
        }
    }
    
    private boolean isValid(char[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || x >= m || y < 0 || y >= n) return false;
        if(visited[x][y]) return false;
        if(grid[x][y] == '0') return false;
        return true;
    }
}

//DFS approach
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    private void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        
        if(grid[x][y] == '0') return;
        grid[x][y] = '0';
        
        for(int k=0; k<4; k++) {
            dfs(grid, x + dx[k], y + dy[k]);
        }
    }
}

//Union Find approach
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        
        UF uf = new UF(m*n);
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    for(int k=0; k<4; k++){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x<0 || x>m-1 || y<0 || y>n-1) continue;
                        if(grid[x][y] == '1'){
                            uf.union(i*n+j, x*n+y);
                        }
                    }
                }
                else num++;
            }
        }
        
        return uf.count() - num;
    }
    
    class UF{
        int count;
        int[] parent;
        
        public UF(int n){
            this.count = n;
            this.parent = new int[n];
            for(int i=0; i<n; i++){
                this.parent[i] = i;
            }
        }
        
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;
            parent[rootA] = rootB;
            count--;
        }
        
        public int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        
        public boolean connected(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
        
        public int count(){
            return this.count;
        }
    }
}
