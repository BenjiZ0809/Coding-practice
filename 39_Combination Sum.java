class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;    
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> minires, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(minires));
            return;
        }
        if(target < 0) return;

        for(int i=index; i<candidates.length; i++) {
            minires.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, minires, res);
            minires.remove(minires.size() - 1);
        }
    }
}
