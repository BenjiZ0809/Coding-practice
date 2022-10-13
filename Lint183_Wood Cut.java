//First approach
public class Solution {
    /**
     * @param l: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] l, int k) {
        int max = 0;
        //这里注意sum要用long，因为l中的数组加起来可能溢出int
        long sum = 0;
        for(int num:l) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = 1;
        int right = (int)Math.min(max, sum / k);
        if(right < 1) return 0;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int total = helper(l, mid);
            if(total < k) right = mid;
            else left = mid;
        }

        return helper(l, right) >= k? right:left;
    }

    private int helper(int[] nums, int len) {
        int sum = 0;
        for(int num:nums) {
            sum += num / len;
        }
        return sum;
    }
}

//Second approach
//两个解法都是二分，区别在于return 0的判断
public class Solution {
    /**
     * @param l: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] l, int k) {
        int max = 0;
        for(int num:l) {
            max = Math.max(max, num);
        }

        int left = 1;
        int right = max;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int total = helper(l, mid);
            if(total < k) right = mid;
            else left = mid;
        }

        if(count(l, right) >= k) return right;
        if(count(l, left) >= k) return left;
        return 0;
    }

    private int helper(int[] nums, int len) {
        int sum = 0;
        for(int num:nums) {
            sum += num / len;
        }
        return sum;
    }
}
