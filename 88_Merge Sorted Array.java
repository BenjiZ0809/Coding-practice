// Better approach
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1;
        int r = n - 1;
        int index = m + n - 1;
        while(l >= 0 && r >= 0) {
            if(nums1[l] > nums2[r]) nums1[index--] = nums1[l--];
            else nums1[index--] = nums2[r--];
        }

        while(l >= 0) nums1[index--] = nums1[l--];
        while(r >= 0) nums1[index--] = nums2[r--];
    }
}


// Use extra space
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
