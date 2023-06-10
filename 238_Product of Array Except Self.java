// 2 arrays
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        pre[0] = 1;
        for(int i=1; i<n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        post[n - 1] = 1;
        for(int i=n-2; i>=0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }
}

// 1 array
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        res[0] = 1;
        for(int i=1; i<n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int temp = 1;
        for(int i=n-2; i>=0; i--) {
            temp = temp * nums[i + 1];
            res[i] = res[i] * temp;
        }
        return res;
    }
}
