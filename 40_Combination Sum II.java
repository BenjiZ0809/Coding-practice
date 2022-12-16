class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, visited, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int[] nums, int target, int index, boolean[] visited, List<Integer> minires, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(minires));
            return;
        }
        if(target < 0) return;

        for(int i=index; i<nums.length; i++) {
            if(i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            minires.add(nums[i]);
            backTrack(nums, target - nums[i], i + 1, visited, minires, res);
            visited[i] = false;
            minires.remove(minires.size() - 1);
        }
    }
}
