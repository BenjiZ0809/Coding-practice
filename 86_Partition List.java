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
    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new  ListNode();
        ListNode rightDummy = new ListNode();
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while(head != null) {
            if(head.val < x) {
                left.next = head;
                left = left.next;
            }
            else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        
        left.next = rightDummy.next;
        right.next = null;
        
        return leftDummy.next;
    }
}
