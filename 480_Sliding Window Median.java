//insertion O((n-k+1)k)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[k];
        double[] res = new double[n - k + 1];
        
        for(int i=0; i<k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        
        for(int i=k; i<=n; i++) {
            res[i - k] = ((double)window[k / 2] + window[(k - 1) / 2]) / 2;
            if(i == n) break;
            remove(window, nums[i - k]);
            insert(window, nums[i]);
        }
        return res;
    }
    
    private void remove(int[] window, int val) {
        int i = 0;
        while(i < window.length && val != window[i]) i++;
        while(i < window.length - 1) window[i] = window[++i];
    }
    
    private void insert(int[] window, int val) {
        int i = 0;
        while(i < window.length && val > window[i]) i++;
        int j = window.length - 1;
        while(j > i) {
            window[j] = window[--j];
        }
        window[j] = val;
    }
}

//Binary search O((n-k+1)logK)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] window = new int[k];
        double[] res = new double[n - k + 1];
        
        for(int i=0; i<k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        
        for(int i=k; i<=n; i++) {
            res[i - k] = ((double)window[k / 2] + window[(k - 1) / 2]) / 2;
            if(i == n) break;
            remove(window, nums[i - k]);
            insert(window, nums[i]);
        }
        return res;
    }
    
    private void remove(int[] window, int val) {
        int i = Arrays.binarySearch(window, val);
        while(i < window.length - 1) window[i] = window[++i];
    }
    
    private void insert(int[] window, int val) {
        int i = Arrays.binarySearch(window, val);
        if(i < 0) i = -i - 1;
        int j = window.length - 1;
        while(j > i) window[j] = window[--j];
        window[j] = val;
    }
}
