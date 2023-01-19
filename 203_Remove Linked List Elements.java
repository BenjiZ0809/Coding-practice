class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode cur = head;
        prev.next = cur;

        while(cur != null) {
            if(cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
