class Solution {
    int[] prefixSum;
    int totalSum;
    
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        int sum = 0;
        for(int i=0; i<w.length; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
        this.totalSum = sum;
    }
    
    public int pickIndex() {
        double target = totalSum * Math.random();
        int low = 0;
        int high = prefixSum.length - 1;
        
        while(high > low) {
            int mid = (high + low) / 2;
            if(target > prefixSum[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}
