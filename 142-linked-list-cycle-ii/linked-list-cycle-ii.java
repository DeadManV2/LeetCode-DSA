public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        boolean hasCycle = false;        
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(s == f) {
                hasCycle = true;
                break;
            }
        }
        if(!hasCycle) return null;

        ListNode curr = head;
        while(curr != null) {
            if(curr == s) return s;
            curr = curr.next;
            s = s.next;
        }
        return s;
    }
} 