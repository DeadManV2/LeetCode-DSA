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
    private int calculateLen(ListNode head){
        ListNode tmp  = head;
        int cnt = 1;
        while(tmp.next != null){
            cnt++;
            tmp = tmp.next;

        }
        return cnt;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null) return head;
        if(k <= 1) return head;
        int len = calculateLen(head);
        ListNode res = new ListNode(-1, head);
        ListNode pre = res;
        ListNode curr = pre.next; 
        while( len >= k){
         
         for(int i = 1; i < k; i++){
            ListNode tmp = pre.next;
            pre.next = curr.next;
            curr.next = curr.next.next;
            pre.next.next = tmp;
         }
         pre = curr;
         curr = pre.next;
         len -= k;

        }

        return res.next;


        
    }
}