class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty() || (s.charAt(i) == ')' && stack.peek() != '(')) return false;
                else if(stack.isEmpty() || (s.charAt(i) == '}' && stack.peek() != '{')) return false;
                else if(stack.isEmpty() || (s.charAt(i) == ']' && stack.peek() != '[')) return false;
                else stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

//Another version
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if(stack.isEmpty()) return false;
                char ch = stack.peek();
                if((s.charAt(i) == ')' && ch != '(') || (s.charAt(i) == ']' && ch != '[') || (s.charAt(i) == '}' && ch != '{')) return false; 
                else stack.pop();
            }
            else stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }
}
