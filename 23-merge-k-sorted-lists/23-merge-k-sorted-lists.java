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
    public ListNode mergeKLists(ListNode[] lists) {
        int left = 0, right = lists.length - 1;
        if(lists.length == 0)
            return null;
        if(lists.length == 1)
            return lists[0];
            
        return mergeListsHelper(lists, left, right);
    }
    
    public ListNode mergeListsHelper(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        else if(left < right){
            int mid = left + (right - left)/2;
            ListNode l1 = mergeListsHelper(lists,left, mid);
            ListNode l2 = mergeListsHelper(lists,mid+1, right);
            ListNode node = merge(l1,l2);
            return node;
        }
        return null;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null || l2 == null){
            return (l1 == null ? l2 : l1);
        }
        ListNode head = null, temp = null;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                if(head == null){
                    head = l1;
                    temp = l1;
                    l1 = l1.next;
                }
                else{
                    temp.next = l1;
                    temp = l1;
                    l1 = l1.next;
                    
                }
            }
            else{
                if(head == null){
                    head = l2;
                    temp = l2;
                    l2 = l2.next;
                }
                else{
                    temp.next = l2;
                    temp = l2;
                    l2 = l2.next;
                    
                }
            }
        }
        if(l1 == null){
            temp.next = l2;
        }
        else if(l2 == null){
            temp.next = l1;
        }
        return head;
    }
}