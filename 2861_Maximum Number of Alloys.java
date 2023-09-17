class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int max = 0;
        for(List<Integer> comp:composition) {
            int temp = binarySearch(comp, stock, cost, budget);
            max = Math.max(max, temp);
        }
        return max;
    }

    public int binarySearch(List<Integer> comp, List<Integer> stock, List<Integer> cost, int budget) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        while(left + 1 < right) {
            long mid = left + (right - left) / 2;
            if(isPossible(mid, comp, stock, cost, budget)) left = mid;
            else right = mid;
        }
        return isPossible(right, comp, stock, cost, budget)? (int)right : (int)left;
    }

    public boolean isPossible(long count, List<Integer> comp, List<Integer> stock, List<Integer> cost, int budget) {
        for(int i=0; i<comp.size(); i++) {
            long temp = Math.max(0, (count * comp.get(i) - stock.get(i)) * cost.get(i));
            if(temp > budget) return false;
            budget -= temp;
           
        }
        return budget >= 0;
    }
}
