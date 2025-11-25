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
        ListNode slow = head;
        ListNode fast = head;
        if(head == null || head.next == null)return true;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newNode = reverseList(slow.next);
        ListNode f = head;
        ListNode s = newNode;
        while(s != null){
            if(f.val != s.val){
                reverseList(newNode);
                return false;
            }
            f = f.next;
            s = s.next;
        }
        reverseList(newNode);
        return true;  
    }
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        ListNode front = head.next;
        front.next= head;
        head.next = null;
        return newHead;
    }
}