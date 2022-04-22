/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode slowPtr = head, fastPtr = slowPtr.next;
        while(slowPtr != null && fastPtr != null && fastPtr.next != null && slowPtr != fastPtr){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }       
        if(slowPtr == fastPtr)
            return true;
        return false;
    }
}