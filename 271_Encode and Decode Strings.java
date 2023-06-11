public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int len = str.length();
            sb.append(len);
            sb.append('#');
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            StringBuilder len = new StringBuilder();
            while(s.charAt(i) != '#') {
                len.append(s.charAt(i));
                i++;
            }
            i++;
            int wordLen = Integer.parseInt(len.toString());
            StringBuilder curWord = new StringBuilder();
            for(int j=i; j<i+wordLen; j++) {
                curWord.append(s.charAt(j));
            }
            i += wordLen - 1;
            res.add(curWord.toString());
        }
        return res;
    }
}
