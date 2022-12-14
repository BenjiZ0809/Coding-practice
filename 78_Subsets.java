class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> minires, List<List<Integer>> res) {
        res.add(new ArrayList<>(minires));
        for(int i=index; i<nums.length; i++) {
            minires.add(nums[i]);
            dfs(nums, i + 1, minires, res);
            minires.remove(minires.size() - 1);
        }
    }
}

//approach 2
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), res);
        return res;        
    }

    private void dfs(int[] nums, int index, List<Integer> minires, List<List<Integer>> res) {
        if(index == nums.length) {
            res.add(new ArrayList<>(minires));
            return;
        }

        minires.add(nums[index]);
        dfs(nums, index + 1, minires, res);
        minires.remove(minires.size() - 1);
        dfs(nums, index + 1, minires, res);
    }
}
