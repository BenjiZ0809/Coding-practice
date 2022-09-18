/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy, start = head, end = head, next = head;
        
        while(next != null) {
            for(int i=1; i<k && end != null; i++) {
                end = end.next;
            }
            if(end == null) {
                break;
            }
            
            next = end.next;
            end.next = null;
            end = start;
            start = reverse(start);
            prev.next = start;
            end.next = next;
            
            prev = end;
            start = end.next;
            end = end.next;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode head) {
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
