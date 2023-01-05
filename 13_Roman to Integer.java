// backwards traverse
class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int num = 0;
        int past = 0;

        for(int i=s.length() - 1; i>=0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1;
                    break;
                case 'V': num = 5;
                    break;
                case 'X': num = 10;
                    break;
                case 'L': num = 50;
                    break;
                case 'C': num = 100;
                    break;
                case 'D': num = 500;
                    break;
                case 'M': num = 1000;
                    break;
            }

            if(past > num) res -= num;
            else res += num;
            past = num;
        }
        return res;
    }
}

// simulation
class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int res = 0;
        for(int i=0; i<n; i++) {
            if(i + 1 < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                res += 4;
                i++;
                continue;
            }
            if(i + 1 < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                res += 9;
                i++;
                continue;
            }
            if(i + 1 < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                res += 40;
                i++;
                continue;
            }
            if(i + 1 < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                res += 90;
                i++;
                continue;
            }
            if(i + 1 < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                res += 400;
                i++;
                continue;
            }
            if(i + 1 < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                res += 900;
                i++;
                continue;
            }
            if(s.charAt(i) == 'I') {
                res += 1;
            }
            if(s.charAt(i) == 'V') {
                res += 5;
            }
            if(s.charAt(i) == 'X') {
                res += 10;
            }
            if(s.charAt(i) == 'L') {
                res += 50;
            }
            if(s.charAt(i) == 'C') {
                res += 100;
            }
            if(s.charAt(i) == 'D') {
                res += 500;
            }
            if(s.charAt(i) == 'M') {
                res += 1000;
            }
        }
        return res;
    }
}
