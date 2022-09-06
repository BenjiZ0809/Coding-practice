//Two partition approach
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            while(left <= right && nums[left] == 0) {
                left++;
            }
            while(left <= right && nums[right] != 0) {
                right--;
            }
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        left = 0;
        right = nums.length - 1;
        while(left <= right) {
            while(left <= right && nums[left] <= 1) {
                left++;
            }
            while(left <= right && nums[right] > 1) {
                right--;
            }
            if(left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }
}


//One partition approach with 3 pointers
class Solution {
    public void sortColors(int[] nums) {
        int left = 0, index = 0;
        int right = nums.length - 1;
        
        while(index <= right) {
            if(nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left++;
                index++;
            }
            else if(nums[index] == 2) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right] = temp;
                right--;
            }
            else index++;
        }
    }
}
