class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, 2, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(int n, int start, List<Integer> minires, List<List<Integer>> res) {
        if(n <= 1) {
            if(minires.size() > 1) {
                res.add(new ArrayList<>(minires));
                return;
            }
        }

        for(int i=start; i<=n; i++) {
            if(n % i == 0) {
                minires.add(i);
                backTrack(n / i, i, minires, res);
                minires.remove(minires.size() - 1);
            }
        }
    }
}
