class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> minires = new ArrayList<>();
            minires.add(1);
            if(i == 1) {
                res.add(minires);
                continue;
            }
            for(int j=1; j<i-1; j++) {
                int num = res.get(i - 2).get(j - 1) + res.get(i - 2).get(j);
                minires.add(num);
            }
            minires.add(1);
            res.add(minires);
        }
        return res;
    }
}
