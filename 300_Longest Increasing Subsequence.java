//binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for(int i=1; i<nums.length; i++) {
            int num = nums[i];
            if(list.get(list.size() - 1) < num) {
                list.add(num);
            }
            else {
                int j = binarySearch(list, num);
                list.set(j, num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> list, int tar) {
        int left = 0;
        int right = list.size() - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(list.get(mid) > tar) {
                right = mid;
            }
            else left = mid;
        }
        if(list.get(left) == tar) return left;
        if(list.get(right) == tar) return right;
        return list.get(left) > tar? left:right;
    }
}

//dp
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int num:dp) res = Math.max(res, num);
        return res;
    }
}
