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
    private ListNode findMiddle(ListNode head){
     if(head == null || head.next == null) return head;

     ListNode slow = head;
     ListNode fast = head;
     while(fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
     }
     return slow;
    }
    private ListNode reverse(ListNode head){
        
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " --> ");
            head = head.next;
        }
    }
    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        ListNode curr = head;
        ListNode fMid = findMiddle(head);
        ListNode mid = fMid.next;
        System.out.println(mid.val);
        fMid.next = null;

        ListNode rev = reverse(mid);
        print(rev);
        print(curr);
        
        while(curr != null &&  rev != null) {
            ListNode currNext = curr.next;
            ListNode revNext = rev.next;
            curr.next = rev;
            rev.next = currNext;
            rev = revNext;
            curr = currNext;
        }
        
    }
}