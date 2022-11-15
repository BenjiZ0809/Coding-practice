class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        UF uf = new UF(m * n);
        List<Integer> res = new ArrayList<>();
        int num = 0;

        for(int[] position:positions) {
            int x = position[0];
            int y = position[1];
            if(grid[x][y] == 1) {
                res.add(num);
                continue;
            }
            grid[x][y] = 1;
            num++;
            for(int k=0; k<4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if(newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                if(grid[newX][newY] == 1 && !uf.connected((x * n + y), (newX * n + newY))) {
                    uf.union((x * n + y), (newX * n + newY));
                    num--;
                }
            }
            res.add(num);
        }
        return res;
    }

    class UF {
        int count;
        int[] parent;
        public UF(int n) {
            this.count = n;
            this.parent = new int[n];
            for(int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;
            parent[rootB] = rootA;
            count--;
        }

        public int find(int a) {
            if(parent[a] != a) {
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }

        public boolean connected(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            return rootA == rootB;
        }
    }
}
