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
    public void reorderList(ListNode head) {
        ListNode firstHalfEnd = findMid(head);
        ListNode secondHalf = reverse(firstHalfEnd.next);
        firstHalfEnd.next = null;
   
        while(head != null && secondHalf != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = secondHalf.next;
            head.next = secondHalf;
            secondHalf.next = temp1;
            head = temp1;
            secondHalf = temp2;
        }
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
    
    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
         
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
