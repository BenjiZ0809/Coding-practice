// greedy (fast)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0, furthest = 0;
        int res = 0;

        while(r < n - 1) {
            for(int i=l; i<=r; i++) {
                furthest = Math.max(furthest, nums[i] + i);
            }
            l = r + 1;
            r = furthest;
            res++;
        }
        return res;
    }
}


// dp (slow)
lass Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
