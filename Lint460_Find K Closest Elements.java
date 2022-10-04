public class Solution {
    /**
     * @param a: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] a, int target, int k) {
        int right = binarySearch(a, target);
        int left = right - 1;

        int index = 0;
        int[] res = new int[k];
        while(index < k) {
            if(isLeftCloser(a, target, left, right)) {
                res[index++] = a[left--];
            }
            else {
                res[index++] = a[right++];
            }
        }
        return res;
    }

    private boolean isLeftCloser(int[]nums, int target, int left, int right) {
        if(left < 0 ) return false;
        if(right >= nums.length) return true;
        return target - nums[left] <= nums[right] - target;
    }

    private int binarySearch(int[] nums, int target) {
        //if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid;
            }
            else right = mid;
        }

        if(nums[left] >= target) return left;
        if(nums[right] >= target) return right;
        return nums.length;
    }
}
