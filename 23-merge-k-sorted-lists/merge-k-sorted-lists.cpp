/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()){
            return nullptr;
        }
        return merger(lists, 0, lists.size()-1);
    }

    ListNode* merger(vector<ListNode*>& lists, int s, int e){
        if(s > e) return nullptr;
        if(s == e) return lists[s];
        int mid = s + (e - s) / 2;
        ListNode* l = merger(lists, s, mid);
        ListNode* r = merger(lists, mid+1, e);
        return mergeTwoLists(l, r);   // ✅ renamed
    }

    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2){
        ListNode* dummy = new ListNode(0);
        ListNode* curr = dummy;
        while(l1 && l2){
            if(l1->val < l2->val){
                curr->next = l1;
                l1 = l1->next;
            } else {
                curr->next = l2;
                l2 = l2->next;
            }
            curr = curr->next;
        }
        curr->next = (l1 ? l1 : l2);
        return dummy->next;
    }
};
