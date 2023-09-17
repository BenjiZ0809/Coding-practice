class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int res = 0;
        int count = 0;

        if(nums.get(0) > 0) res++;
        count++;

        for(int i=1; i<nums.size(); i++) {
            if(nums.get(i - 1) < count && nums.get(i) > count) res++;
            count++;
        }

        if(nums.get(nums.size() - 1) < count) res++;

        return res;
    }
}
