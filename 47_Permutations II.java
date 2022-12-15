class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> minires, List<List<Integer>> res) {
        if(minires.size() == nums.length) {
            res.add(new ArrayList<>(minires));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;
            if(i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            minires.add(nums[i]);
            dfs(nums, visited, minires, res);
            visited[i] = false;
            minires.remove(minires.size() - 1);
        }
    }
}
