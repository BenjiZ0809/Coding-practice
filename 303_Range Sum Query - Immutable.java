class NumArray {
    //int[] arr;
    int[] sum;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.sum = new int[n];
        sum[0] = nums[0];
        for(int i=1; i<n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        
    }
    
    public int sumRange(int left, int right) {
        if(left == 0) return sum[right];
        else return sum[right] - sum[left - 1];
    }
}
