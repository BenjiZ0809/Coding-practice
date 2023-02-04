class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.getDist() - b.getDist());
        for(int[] point:points) {
            pq.offer(new Pair(point[0], point[1]));
        }

        int[][] res = new int[k][2];
        int index = 0;
        while(index < k) {
            Pair pair = pq.poll();
            res[index][0] = pair.x;
            res[index][1] = pair.y;
            index++;
        }
        return res;
    }

    class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDist() {
            return x * x + y * y;
        }
    }
}
