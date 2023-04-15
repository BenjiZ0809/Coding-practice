class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, furthest = 0;
        int res = 0;

        while(r < n - 1) {
            for(int i=l; i<=r; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            l = r + 1;
            r = furthest;
            res++;
        }
        return res;
    }
}
