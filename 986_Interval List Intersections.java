class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length == 0 || secondList.length == 0) return new int[0][0];
        List<int[]> res = new ArrayList<>();
        int a = 0;
        int b = 0;
        int n = firstList.length;
        int m = secondList.length;
        while(a < n && b < m) {
            int[] curA = firstList[a];
            int[] curB = secondList[b];
            if(isOverlap(curA, curB)) {
                int[] temp = new int[2];
                temp[0] = Math.max(curA[0], curB[0]);
                temp[1] = Math.min(curA[1], curB[1]);
                res.add(temp);
                if(curA[1] < curB[1]) a++;
                else b++;
            }
            else {
                if(curA[1] < curB[0]) a++;
                else b++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public boolean isOverlap(int[] curA, int[] curB) {
        if((curA[1] >= curB[0] && curA[0] <= curB[1]) || (curB[1] >= curA[0] && curB[0] <= curA[1])) return true;
        return false;
    }
}
