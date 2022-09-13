class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(right > left) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int cur = width * minHeight;
            max = Math.max(max, cur);
            
            if(height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
