class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int res = -1;
        
        while(right > left) {
            int sum = nums[left] + nums[right];
            if(sum >= k) right--;
            else {
                res = Math.max(res, sum);
                left++;
            }
        }
        return res;
    }
}
