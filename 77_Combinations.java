class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int n, int k, int index, List<Integer> minires, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(minires));
            return;
        }

        for(int i=index; i<=n; i++) {
            minires.add(i);
            backTrack(n, k - 1, i + 1, minires, res);
            minires.remove(minires.size() - 1);
        }
    }   
}
