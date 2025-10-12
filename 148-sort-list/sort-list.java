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
    public ListNode join(ListNode start, ListNode mid)
    {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (start != null && mid != null)
        {
            if (start.val < mid.val)
            {
                temp.next = start;
                start = start.next;
            }
            else 
            {
                temp.next = mid;
                mid = mid.next;
            }
            temp = temp.next;
        }

        if (start != null) temp.next = start;
        if (mid != null) temp.next = mid;

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)return head;
        ListNode slow = head , fast = head;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        return join(sortList(head),sortList(fast));
    }
}