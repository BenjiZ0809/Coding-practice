class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for(int i=0; i<n; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] cur = stack.pop();
                int index = cur[0];
                int height = cur[1];
                int curArea = height * (i - index);
                res = Math.max(res, curArea);
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()) {
            int[] cur = stack.pop();
            int index = cur[0];
            int height = cur[1];
            int curArea = height * (n - index);
            res = Math.max(res, curArea);
        }
        return res;
    }
}
