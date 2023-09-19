class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1;
        int max = 1;
        for(int num:nums) {
            int temp = max * num;
            max = Math.max(num, Math.max(temp, min * num));
            min = Math.min(num, Math.min(temp, min * num));
            res = Math.max(max, res);
        }
        return res;
    }
}
