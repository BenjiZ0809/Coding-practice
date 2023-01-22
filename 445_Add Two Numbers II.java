//reverse linked list
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0) {
            int v1 = l1 == null? 0:l1.val;
            int v2 = l2 == null? 0:l2.val;
            int value = v1 + v2 + carry;
            carry = value / 10;
            int newVal = value % 10;
            ListNode node = new ListNode(newVal);
            cur.next = node;
            cur = cur.next;
            l1 = l1 == null? null:l1.next;
            l2 = l2 == null? null:l2.next;
        }
        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}

//without reverse(stack)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int v1 = stack1.isEmpty()? 0:stack1.pop();
            int v2 = stack2.isEmpty()? 0:stack2.pop();
            int value = v1 + v2 + carry;
            int newVal = value % 10;
            carry = value / 10;
            ListNode node = new ListNode(newVal);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}
