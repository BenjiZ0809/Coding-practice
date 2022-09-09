class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];
        
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                res[i + j + 1] += a * b;
            }
        }
        int carry = 0;
        for(int i=m+n-1; i>=0; i--) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] = res[i] % 10;
        }
        
        String str = "";
        for(int i=0; i<m+n; i++) {
            if(str.equals("") && res[i] == 0) continue;
            str += res[i];
        }
        
        return str;
    }
}
