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


//PQ
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Queue<Integer> min = new PriorityQueue<>();
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        double[] res = new double[n - k + 1];
        int index = 0, i = 0, j = 0;

        while(j < n) {
            if(min.size() <= max.size()) {
                max.offer(nums[j]);
                min.offer(max.poll());
            }
            else {
                min.offer(nums[j]);
                max.offer(min.poll());
            }

            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                if(min.size() == max.size()) {
                    res[index++] = ((long)min.peek() + (long)max.peek()) / 2.0;
                }
                else {
                    res[index++] = (double)min.peek();
                }
                if(min.contains(nums[i])) min.remove(nums[i]);
                else max.remove(nums[i]);
                i++;
                j++;
            }
        }
        return res;
    }
}
