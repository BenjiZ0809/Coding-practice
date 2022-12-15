class Solution {
    final String[] KEYBOARD = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        dfs(digits, 0, new StringBuilder(), res);
        return res;    
    }

    private void dfs(String digits, int index, StringBuilder sb, List<String> res) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }   

        int n = digits.charAt(index) - '0';
        for(int i=0; i<KEYBOARD[n].length(); i++) {
            sb.append(KEYBOARD[n].charAt(i));
            dfs(digits, index + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
