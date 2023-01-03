class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] arr = new int[n + 1];
        for(int num : nums) {
            arr[num]++;
        }

        for(int i=0; i<=n; i++) {
            if(arr[i] > 1) res.add(i);
        }
        return res;
    }
}
