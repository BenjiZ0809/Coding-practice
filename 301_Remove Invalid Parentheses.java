class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        backTrack(s, 0, 0, '(', ')', res);
        return res;
    }

    private void backTrack(String s, int iStart, int jStart, char open, char close, List<String> res) {
        int count = 0;
        for(int i=iStart; i<s.length(); i++) {
            if(s.charAt(i) == open) count++;
            if(s.charAt(i) == close) count--;
            if(count < 0) {
                for(int j=jStart; j<=i; j++) {
                    if(s.charAt(j) == close && (j == jStart || s.charAt(j - 1) != close)) {
                        backTrack(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, open, close, res);
                    }
                }
                return;
            }
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(open == '(') backTrack(reverse, 0, 0, ')', '(', res);
        else res.add(reverse);
    }
}
