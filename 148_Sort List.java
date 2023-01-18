class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode midPrev = null;
        while(head != null && head.next != null) {
            midPrev = midPrev == null? head:midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(left != null && right != null) {
            if(left.val < right.val) {
                cur.next = left;
                left = left.next;
                cur = cur.next;
            }
            else {
                cur.next = right;
                right = right.next;
                cur = cur.next;
            }
        }

        cur.next = left == null? right:left;
        return dummy.next;
    }
}
