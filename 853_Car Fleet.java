// Approach 1 
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);

        int fleet = 0;
        double prev = -1.0;
        for(int i=n-1; i>=0; i--) {
            double cur = (target - cars[i][0]) * 1.0 / cars[i][1];
            if(cur > prev) {
                fleet++;
                prev = cur;
            }
        }
        return fleet;
    }
}

// Approach 2
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for(int i=0; i<position.length; i++) {
            time[position[i]] = (target - position[i]) / (speed[i] * 1.0);
        }

        int res = 0;
        double max = 0;
        for(int i=target - 1; i>=0; i--) {
            if(time[i] > max) {
                max = time[i];
                res++;
            }
        }
        return res;
    }
}
