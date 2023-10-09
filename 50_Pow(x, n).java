class Solution {
    public double myPow(double x, int n) {
        double res = helper(x, n);
        return n > 0? res : 1 / res;
    }

    public double helper(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        double res = helper(x, n / 2);
        res *= res;
        if(n % 2 != 0) res *= x;
        return res;
    }
}
