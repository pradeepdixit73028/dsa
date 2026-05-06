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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start=list1;
        for(int i=0;i<a-1;i++){
            start=start.next;
        }
        ListNode end=start;
        for(int i=0;i<=(b-a+1);i++){
            end=end.next;
        }
        ListNode tail=list2;
        while(tail.next!=null){
            tail=tail.next;
        }
        start.next=list2;
        tail.next=end;
        return list1;
    }
}