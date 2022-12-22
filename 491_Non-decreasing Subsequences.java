class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[] nums, int index, List<Integer> minires, List<List<Integer>> res) {
        if(minires.size() > 1) res.add(new ArrayList<>(minires));

        Set<Integer> visited = new HashSet<>();
        for(int i=index; i<nums.length; i++) {
            if(!minires.isEmpty() && nums[i] < minires.get(minires.size() - 1)) continue;
            if(visited.contains(nums[i])) continue;
            visited.add(nums[i]);
            minires.add(nums[i]);
            backTrack(nums, i + 1, minires, res);
            minires.remove(minires.size() - 1);
        } 
    }
}
