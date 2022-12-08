class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, 0, visited, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, boolean[] visited, List<Integer> minires, List<List<Integer>> res) {
        res.add(new ArrayList<>(minires));
        for(int i=index; i<nums.length; i++) {
            if(i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            minires.add(nums[i]);
            dfs(nums, i + 1, visited, minires, res);
            visited[i] = false;
            minires.remove(minires.size() - 1);
        }
    }
}
