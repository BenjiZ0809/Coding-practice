    public int findMissing2(int n, String s) {
        List<Integer> arr = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            arr.add(i);
        }
        backTrack(s, 0, n, arr);
        return res;
    }

    int res;
    private void backTrack(String s, int index, int n, List<Integer> arr) {
        if(arr.size() == 1) {
            res = arr.get(0);
        }

        for(int i=index; i<s.length(); i++) {
            if(i - index > 1) continue;
            if(isValid(s, index, i, n, arr)) {
                arr.remove(Integer.valueOf(s.substring(index, i + 1)));
                backTrack(s, i + 1, n, arr);
                arr.add(Integer.valueOf(s.substring(index, i + 1)));
            }
        }
    }

    private boolean isValid(String s, int start, int end, int n, List<Integer> arr) {
        int num = Integer.parseInt(s.substring(start, end + 1));
        if(num < 1 || num > n) return false;
        if(!arr.contains(num)) return false;
        return true;
    }
}
