class solution {
  public static void partition(int[] nums, int low, int high) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        
        while(index <= right) {
            if(nums[index] < low) {
                int temp = nums[index];
                nums[index] = nums[left];
                nums[left] = temp;
                index++;
                left++;
            }
            else if (nums[index] > high) {
                int temp = nums[index];
                nums[index] = nums[right];
                nums[right] = temp;
                right--;
            }
            else index++;
        }
    }
}
