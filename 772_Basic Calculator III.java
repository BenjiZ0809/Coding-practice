//reverse polish notation
class Solution {
    public int calculate(String s) {
        List<String> list = getList(s);
        int res = getRes(list);
        return res;   
    }

    private List<String> getList(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        int num = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(Character.isDigit(s.charAt(i))) {
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                list.add(num + "");
            }
            else if(s.charAt(i) == '(') stack.push(s.charAt(i) + "");
            else if(s.charAt(i) == ')') {
                while(!stack.isEmpty()) {
                    if(stack.peek().equals("(")) {
                        stack.pop();
                        break;
                    }
                    list.add(stack.pop());
                }
            }
            else {
                while(!stack.isEmpty()) {
                    if(stack.peek().equals("(")) break;
                    if(getPriority(stack.peek()) >= getPriority(s.charAt(i) + "")) {
                        list.add(stack.pop());
                    }
                    else break;
                }
                stack.push(s.charAt(i) + "");
                num = 0;
            }
        }  
        while(!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    private int getPriority(String s) {
        if(s.equals("*") || s.equals("/")) return 2;
        else return 1;
    }

    private int getRes(List<String> list) {
        Stack<Integer> stack = new Stack<>();

        for(String str:list) {
            if(Character.isDigit(str.charAt(0))) {
                stack.push(Integer.valueOf(str));
            }
            else {
                int temp = 0;
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(str.equals("+")) temp = num2 + num1;
                else if(str.equals("-")) temp = num2 - num1;
                else if(str.equals("*")) temp = num2 * num1;
                else if(str.equals("/")) temp = num2 / num1;
                stack.push(temp);
            }
        } 
        return stack.peek();   
    }
}

//easier approach with recursion
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            else if(s.charAt(i) == '(') {
                int count = 1;
                int j = i + 1;
                while(j < s.length()) {
                    if(s.charAt(j) == '(') count++;
                    if(s.charAt(j) == ')') count--;
                    if(count == 0) break;
                    j++;
                }
                num = calculate(s.substring(i + 1, j));
                i = j;
            }
            
            if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' || i == s.length() - 1) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                sign = s.charAt(i);
            }
        }
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
