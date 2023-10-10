// slow
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] res = new int[32];
        int index = 0;
        while(n != 0) {
            int bit = n & 1;
            res[index++] = bit;
            n >>>= 1;
        }
        System.out.print(Arrays.toString(res));
        long num = 0;
        for(int i=0; i<32; i++) {
            num += res[i] * Math.pow(2, 32 - i - 1);
            System.out.println(num);
        }

        return (int)num;
    }
}

// fast (bit)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int bit = (n >> i) & 1;
            res = res | (bit << (31 - i));
        }
        return res;
    }
}
