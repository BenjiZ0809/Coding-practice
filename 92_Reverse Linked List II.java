class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy, start = head, end = head, next = end.next;
        prev.next = start;

        while(left > 1) {
            start = start.next;
            prev = prev.next;
            left--;
        }
        while(right > 1) {
            end = end.next;
            next = end.next;
            right--;
        }

        end.next = null;
        end = start;
        start = reverse(start);
        prev.next = start;
        end.next = next;

        return dummy.next;
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
