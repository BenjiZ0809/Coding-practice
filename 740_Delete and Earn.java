// approach 1
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num:nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
            max = Math.max(max, num);
        } 

        int prevInclude = 0;
        int prevExclude = 0;
        for(int i=min; i<=max; i++) {
            int include = prevExclude + i * freq.getOrDefault(i, 0);
            int exclude = Math.max(prevInclude, prevExclude);
            prevInclude = include;
            prevExclude = exclude;
        }
        return Math.max(prevInclude, prevExclude);
    }
}

// approach 2
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num:nums) {
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];
        for(int num:nums) {
            dp[num] += num;
        }

        for(int i=2; i<=max; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i], dp[i - 1]);
        }
        return dp[max];
    }
}
