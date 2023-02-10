//With stack
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int num = 0;
        char sign = '+';

        for(int i=0; i<n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            else if(s.charAt(i) == '(') {
                int count = 1;
                int j = i + 1;
                while(j < n) {
                    if(s.charAt(j) == '(') count++;
                    if(s.charAt(j) == ')') count--;
                    if(count == 0) break;
                    j++;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }

            if(s.charAt(i) == '+' || s.charAt(i) == '-' || i == n - 1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

//No stack one pass
class Solution {
    int index = 0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        int res = 0;
        int n = s.length();

        while(index < n) {
            char ch = s.charAt(index++);
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            else if(ch == '(') {
                num = calculate(s);
            }
            else if(ch == ')') {
                res += num * sign;
                return res;
            }
            else if(ch == '+' || ch == '-') {
                res += sign * num;
                num = 0;
                sign = ch == '-'? -1:1;
            }
        }
        return res + sign * num;
    }
}
