class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        dummy.next = head;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                prev.next = head.next; 
                head = head.next;
            }
            else {
                prev = prev.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
