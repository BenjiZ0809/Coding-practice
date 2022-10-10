class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        if(m == 0) {
            if(n % 2 == 0) return (nums2[n / 2] + nums2[(n / 2) - 1]) / 2.0;
            else return nums2[n / 2];
        }
        if(n == 0) {
            if(m % 2 == 0) return (nums1[m / 2] + nums1[(m / 2) - 1]) / 2.0;
            else return nums1[m / 2];
        }
        
        if(m > n) return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = m;
        while(start <= end) {
            int cutA = start + (end - start) / 2;
            int cutB = (m + n) / 2 - cutA;
            
            int left1 = cutA == 0? Integer.MIN_VALUE:nums1[cutA - 1];
            int right1 = cutA == m? Integer.MAX_VALUE:nums1[cutA];
            int left2 = cutB == 0? Integer.MIN_VALUE:nums2[cutB - 1];
            int right2 = cutB == n? Integer.MAX_VALUE:nums2[cutB];
            
            if(left1 > right2) end = cutA - 1;
            else if(left2 > right1) start = cutA + 1;
            else {
                if((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else {
                    return Math.min(right1, right2);
                }
            }
        }
        return -1; 
    }
}
