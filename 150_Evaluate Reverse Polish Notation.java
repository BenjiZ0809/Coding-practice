class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.valueOf(str));
            }
            else {
                int second = stack.pop();
                int first = stack.pop();
                int num = 0;
                switch (str) {
                    case "+":
                        num = first + second;
                        break;
                    case "-":
                        num = first - second;
                        break;
                    case "*":
                        num = first * second;
                        break;
                    case "/":
                        num = first / second;
                        break;
                }
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
