class Solution {
    int[] prefixSum;
    int sum;

    public Solution(int[] w) {
        int n = w.length;
        this.prefixSum = new int[n];
        this.sum = 0;

        for(int i=0; i<n; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }    
    }
    
    public int pickIndex() {
        double tar = (Math.random() * sum);
        int index = binarySearch(prefixSum, tar);
        return Math.abs(index) - 1;
    }

    private int binarySearch(int[] window, double val) {
        int left = 0;
        int right = window.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(window[mid] > val) {
                right = mid - 1;
            }
            else if(window[mid] < val) {
                left = mid + 1;
                mid++;
            }
            else return mid;
        }
        return -mid - 1;
    }
}
