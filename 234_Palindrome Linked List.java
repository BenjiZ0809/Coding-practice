//ArrayList & two pointer approach
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int left = 0;
        int right = list.size() - 1;
        
        while(left <= right) {
            if(list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}

//Flip half of the list approach
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
    public boolean isPalindrome(ListNode head) {
        ListNode firstHalfLast = findMid(head);
        ListNode secondHalfStart = reverse(firstHalfLast.next);
        
        ListNode n1 = head;
        ListNode n2 = secondHalfStart;
        while(n1 != null && n2 != null) {
            if(n1.val != n2.val) {
                firstHalfLast.next = reverse(secondHalfStart);
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        firstHalfLast.next = reverse(secondHalfStart);
        return true;
    }
    
    public ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
