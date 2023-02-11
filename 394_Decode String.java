class Solution {
    public String decodeString(String s) {
        Stack<Integer> timeStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        int n = s.length();
        String res = "";
        int time = 0;

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                time = time * 10 + ch - '0';
            }
            else if(ch == '[') {
                timeStack.push(time);
                strStack.push(res);
                res = "";
                time = 0;
            }
            else if(ch == ']') {
                int curTime = timeStack.pop();
                String curStr = strStack.pop();
                while(curTime > 0) {
                    curStr += res;
                    curTime--;
                }
                res = curStr;
            }
            else {
                res += ch;
            }
        }
        return res;
    }
}
