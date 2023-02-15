class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                res[stack.pop()] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
