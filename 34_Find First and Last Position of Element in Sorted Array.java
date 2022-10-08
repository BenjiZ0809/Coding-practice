//2 binary search approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        
        return res;
    }
    
    private int findFirst(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid;
            else left = mid;
        }
        
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
    
    private int findLast(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target) left = mid;
            else right = mid;
        }
        
        if(nums[right] == target) return right;
        if(nums[left] == target) return left;
        return -1;
    }
}



//1 binary search + 2 pointer O(logn + k), k = number of elements equals to target
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums.length == 0) return res;
        int left = 0;
        int right = nums.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target) right = mid;
            else left = mid;
        }
        
        if(nums[left] == target) right = left;
        else if(nums[right] == target) left = right;
        else return res;
        
        while(right < nums.length && nums[right] == target) right++;
        right--;
        res[0] = left;
        res[1] = right;
        
        return res;
    }
}
