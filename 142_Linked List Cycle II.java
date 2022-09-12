/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode intersection = null;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                intersection = slow;
                break;
            }
        }
        
        ListNode cur = head;
        if(intersection == null) return null;
        else {
            while(cur != intersection) {
                cur = cur.next;
                intersection = intersection.next;
            }
            return cur;
        }
    }
}
