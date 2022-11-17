class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effTo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(effTo[i], Integer.MAX_VALUE);
        }
        effTo[0][0] = 0;
        Queue<State> pq = new PriorityQueue<>((a,b) -> a.effFromStart - b.effFromStart);
        pq.offer(new State(0,0,0));
        
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curEff = cur.effFromStart;
            if(curX == m-1 && curY == n-1) {
                return curEff;
            }
            if(curEff > effTo[curX][curY]) continue;
            for(int[] neighbor:adj(heights, curX, curY)){
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effToNext = Math.max(effTo[curX][curY], Math.abs(heights[nextX][nextY] - heights[curX][curY]));
                if(effToNext < effTo[nextX][nextY]){
                    effTo[nextX][nextY] = effToNext;
                    pq.offer(new State(nextX, nextY, effToNext));
                }
            }
        }
        return -1;
        
    }
    
    class State{
        int x;
        int y;
        int effFromStart;
        public State(int x, int y, int effFromStart){
            this.x = x;
            this.y = y;
            this.effFromStart = effFromStart;
        }
    }

    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    public List<int[]> adj(int[][] heights, int a, int b){
        List<int[]> neighbor = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        for(int i=0; i<4; i++){
            int x = a + dx[i];
            int y = b + dy[i];
            if(x<0 || x>m-1 || y<0 || y>n-1) continue;
            neighbor.add(new int[]{x,y});
        }
        return neighbor;
    }
}
