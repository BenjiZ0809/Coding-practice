class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int index = 0;
        int[] res = new int[m+n];
        
        while(left < m && right < n) {
            if(nums1[left] < nums2[right]) {
                res[index++] = nums1[left++];
            }
            else {
                res[index++] = nums2[right++];
            }
        }
        
        while(left < m) {
            res[index++] = nums1[left++];
        }
        while(right < n) {
            res[index++] = nums2[right++];
        }
        
        for(int i=0; i<m+n; i++) {
            nums1[i] = res[i];
        }
    }
}
