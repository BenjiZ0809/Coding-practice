class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length < 3) return 0;
        Arrays.sort(nums);
        int count = 0;
      
        for(int i=nums.length - 1; i>=2; i--) {
            int left = 0;
            int right = i-1;
            
            while(right > left) {
                int sum = nums[right] + nums[left];
                if(sum > nums[i]) {
                    count += right - left;
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return count;
    }
}
