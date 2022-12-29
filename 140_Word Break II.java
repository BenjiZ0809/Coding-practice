class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        backTrack(s, wordDict, 0, "", res);
        return res;
    }

    private void backTrack(String s, List<String> wordDict, int index, String path, List<String> res) {
        if(index >= s.length()) {
            res.add(path.trim());
        }

        for(int i=index; i<s.length(); i++) {
            if(wordDict.contains(s.substring(index, i + 1))) {
                backTrack(s, wordDict, i + 1, path + s.substring(index, i + 1) + " ", res);
            }
        }
    }
}
