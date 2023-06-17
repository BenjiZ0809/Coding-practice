class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temperatures[stack.peekLast()] < temperatures[i]) {
                int index = stack.pollLast();
                res[index] = i - index;
            }
            stack.offerLast(i);
        }
        return res;
    }
}
