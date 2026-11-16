class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode a = list1;
        ListNode b = list2;
        ListNode res = new ListNode(-1);
        ListNode c = res;
        while(a != null && b != null) {
         if(a.val < b.val){
           c.next = new ListNode(a.val);
           a = a.next;
           c = c.next;
         }
         else {
            c.next = new ListNode(b.val);
            c = c.next;
            b = b.next;
         }
        }
        if(a != null) c.next = a;
        if(b != null) c.next = b;

        return res.next;
        
    }
}