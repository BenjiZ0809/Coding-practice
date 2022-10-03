class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        
        for(int i=0; i<nums.length-2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int tar = target - nums[i];

            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum >= tar) right--;
                else {
                    res += right - left;
                    left++;
                }
            }
        }
        return res;
    }
}
