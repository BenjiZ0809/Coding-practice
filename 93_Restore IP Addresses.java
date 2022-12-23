//Naive way
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) return res;
        backTrack(s, 0, 0, res);
        return res;
    }

    private void backTrack(String s, int index, int num, List<String> res) {
        if(num == 3) {
            if(isValid(s, index, s.length() - 1)) {
                res.add(s);
                return;
            }
        }

        for(int i=index; i<s.length(); i++) {
            if(isValid(s, index, i)) {
                s = s.substring(0, i + 1) + '.' + s.substring(i + 1);
                num++;
                backTrack(s, i + 2, num, res);
                num--;
                s = s.substring(0, i + 1) + s.substring(i + 2);
            }
            else break;
        }
    }

    private boolean isValid(String s, int start, int end) {
        if(start > end) return false;
        if(s.charAt(start) == '0' && start != end) return false;
        
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { 
                return false;
            }
        }
        long num = Long.valueOf(s.substring(start, end + 1));
        if(num < 0 || num > 255) return false;
        return true;

    }
}

//Optimized way
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTrack(s, 0, 0, new StringBuilder(), res);
        return res;
    }

    private void backTrack(String s, int index, int count, StringBuilder sb, List<String> res) {
        if(index == s.length() && count == 4) {
            res.add(sb.toString());
            return;
        }
        if(index == s.length() || count == 4) return;

        for(int i=index; i<s.length(); i++) {
            if(i - index >= 3) continue;
            if(s.charAt(index) == '0' && index != i) continue;
            int num = Integer.parseInt(s.substring(index, i + 1));
            if(num < 0 || num > 255) continue;
            
            sb.append(num);
            if(count < 3) sb.append('.');
            count++;
            backTrack(s, i + 1, count, sb, res);
            count--;
            sb.delete(index + count, i + count + 2);
        }
    }
}
