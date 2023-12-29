// Approach 1
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

// Approach 2
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i-1; j>=0 && temperatures[i] > temperatures[j]; j--) {
                res[j] = i - j;
            }
        }
        return res;
    }
}
