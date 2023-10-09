class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for(int i=0; i<=n; i++) {
            res[i] = getOneBit(i);
        }
        return res;
    }

    public int getOneBit(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}
