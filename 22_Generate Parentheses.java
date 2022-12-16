class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backTrack(int n, int left, int right, StringBuilder sb, List<String> res) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }
        if(right > left) return;

        if(left < n) {
            sb.append('(');
            backTrack(n, left + 1, right, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < n) {
            sb.append(')');
            backTrack(n, left, right + 1, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
