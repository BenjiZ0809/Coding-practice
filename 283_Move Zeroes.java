//Normal solution
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}

//Solution with minimal operation
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        
        while(right < nums.length) {
            if(nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        
        while(left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}
