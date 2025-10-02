/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null){
            return null;
        }
        if(headB==null){
            return null;
        }
        ListNode sm=null;
        ListNode big=null;
        ListNode slow=headA;
        ListNode fast=headA;
        int size1=1;
        int size2=1;
        int diff=0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            size1+=2;
        }
         if(fast==null){
            size1-=1;
         }
         fast=headB;
         slow=headB;
         while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            size2+=2;
        }
        if(fast==null){
            size2-=1;
         }
         
         if(size1>size2){
            big=headA;
            sm=headB;
            diff=size1-size2;
         }else if(size2>size1){
            big=headB;
            sm=headA;
            diff=size2-size1;
         }else{
          return compare(headA, headB);
         }
        while(diff>0){
           big=big.next;
           diff-=1;
        }
       return compare(big, sm);

    }
    public ListNode compare(ListNode headA, ListNode headB){
            ListNode temp1=headA;
            ListNode temp2=headB;
            while(temp1!=null){
                if(temp1==temp2){
                    return temp1;
                }
                temp1=temp1.next;
                temp2=temp2.next;
            }
            return null;      
    }
}