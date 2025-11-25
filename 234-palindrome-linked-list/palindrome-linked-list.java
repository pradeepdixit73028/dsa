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
    ListNode node;
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;   
        if(node == null) node = head;
        boolean bool = isPalindrome(head.next);
        if(head.val == node.val)
            node = node.next;
        else
            bool = false;
        return bool;
    }
}