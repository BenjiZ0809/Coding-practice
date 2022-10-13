public static double sq(double x) {
    double start = 0.0;
    double end = x;
    if(x < 1) end = 1.0;

    while(start + 1e-12 < end) {
        double mid = start + (end - start) / 2;
        if(mid * mid > x) end = mid;
        else start = mid;
    }

    if(end * end <= x) return end;
    if(start * start <= x) return start;
    return -1.0;
}
