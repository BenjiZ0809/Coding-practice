class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer> enter = new ArrayDeque<>();
        Queue<Integer> exit = new ArrayDeque<>();
        for(int i=0; i<state.length; i++) {
            if(state[i] == 0) enter.offer(i);
            else exit.offer(i);
        }

        int prev = 1;
        int time = 0;
        int[] res = new int[state.length];
        while(!enter.isEmpty() || !exit.isEmpty()) {
            int enterTime = enter.isEmpty()? Integer.MAX_VALUE : arrival[enter.peek()];
            int exitTime = exit.isEmpty()? Integer.MAX_VALUE : arrival[exit.peek()];
            if(enterTime <= time && exitTime <= time) {
                if(prev == 0) {
                    int index = enter.poll();
                    res[index] = time;
                    prev = 0;
                }
                else {
                    int index = exit.poll();
                    res[index] = time;
                    prev = 1;
                }
            }
            else if(enterTime <= time) {
                int index = enter.poll();
                res[index] = time;
                prev = 0;
            }
            else if(exitTime <= time) {
                int index = exit.poll();
                res[index] = time;
                prev = 1;
            }
            else {
                prev = 1;
                time = Math.min(enterTime, exitTime) - 1;
            }
            time++;
        }
        return res;
    }
}
