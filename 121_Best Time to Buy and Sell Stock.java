//two pointer
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int buy = 0;
        int sell = 1;

        while(sell < prices.length) {
            if(prices[buy] > prices[sell]) {
                buy++;
            }
            else if(prices[buy] == prices[sell]) {
                sell++;
            }
            else {
                int profit = prices[sell] - prices[buy];
                res = Math.max(res, profit);
                sell++;
            }
        }
        return res;
    }
}

//dp?
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        int res = 0;
        dp[0] = prices[0];

        for(int i=1; i<prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
        }
        for(int i=0; i<prices.length; i++) {
            res = Math.max(res, prices[i] - dp[i]);
        }
        return res;
    }
}

//dp2?
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;

        for(int i=0; i<prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
