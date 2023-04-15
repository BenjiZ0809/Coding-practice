// Approach 1
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int goal = n - 1;
        for(int i = n - 2; i >= 0; i--) {
            if(nums[i] + i >= goal) goal = i;
        }
        return goal == 0;
    }
}

// Approach 2
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for(int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);
            if(farthest <= i) return false;
        }
        return farthest >= n - 1;
    }
}
