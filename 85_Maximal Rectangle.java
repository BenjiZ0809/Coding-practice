class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        int[] temp = new int[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == '1') temp[j]++;
                else temp[j] = 0;
            }
            res = Math.max(res, maxArea(temp));
        }
        return res;
    }

    private int maxArea(int[] nums) {
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for(int i=0; i<n; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > nums[i]) {
                int[] cur = stack.pop();
                int index = cur[0];
                int height = cur[1];
                int curArea = height * (i - index);
                res = Math.max(res, curArea);
                start = index;
            }
            stack.push(new int[]{start, nums[i]});
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
