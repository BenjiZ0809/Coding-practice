class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        int n = s.length();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') stack.push(i);
            if(ch == ')') {
                if(stack.isEmpty()) set.add(i);
                else stack.pop();
            }
        }

        while(!stack.isEmpty()) set.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(!set.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
