class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backTrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(String s, int index, List<String> minires, List<List<String>> res) {
        if(index == s.length()) {
            res.add(new ArrayList<>(minires));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                minires.add(s.substring(index, i + 1));
                backTrack(s, i + 1, minires, res);
                minires.remove(minires.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int a, int b) {
        int left = a;
        int right = b;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
