// approach 1
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

// approach 2
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m + n];

        for(int i=n-1; i>=0; i--) {
            for(int j=m-1; j>=0; j--) {
                int p1 = i + j;
                int p2 = i + j + 1;
                int num = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                num += res[p2];
                res[p1] += num / 10;
                res[p2] = num % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(res[0] == 0) {
            for(int i=1; i<m+n; i++) {
                sb.append(res[i]);
            }
            return sb.toString();
        }
        for(int i=0; i<m+n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
